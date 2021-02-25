package io.github.armramzing.aier.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.PageTurnWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class HelpBookScreen extends Screen {

    private byte page = 1;
    private final byte maxPage = 2;
    private MatrixStack matrice;

    public HelpBookScreen(byte page) {
        super(Text.of("helpbook"));
        this.page = page;
    }

    public HelpBookScreen() {
        super(Text.of("helpbook"));
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.matrice = matrices;
        this.renderBackground(matrices);
        RenderSystem.color4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.client.getTextureManager().bindTexture(getPage(page));
        int x = (this.width - 375) / 2;
        int y = (this.height - 260) / 2;
        this.drawTexture(matrices, x, y, 0, 0, 375, 220,375,220);

        //画按钮
        if (page != maxPage) {
            this.addButton(new PageTurnWidget(x + 332, y + 187, true, (buttonWidget) -> {
                this.goToNextPage();
            }, true));
        }
        if (page != 1) {
            this.addButton(new PageTurnWidget(x + 23, y + 187, false, (buttonWidget) -> {
                this.goToLastPage();
            }, true));
        }

        //画文本 字号9 字高11px
        TextRenderer textRenderer1 = this.textRenderer;

        switch (page) {
            case 1:
                //左
                textRenderer1.draw(matrices, "§l打败量子力学", x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "走上你的革命之路。", x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "By: AmazingRabbit Studio", x + 24, y + 120, 0);
                textRenderer1.draw(matrices, "Special Thanks: OverRun Organization & mo_java30433", x + 24, y + 150, 0);
                //右
                break;
        }
        super.render(matrices, mouseX, mouseY, delta);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        System.out.print("X:" + (int)mouseX + " Y:" + (int)mouseY + "\n");
        super.mouseClicked(mouseX,mouseY,button);
        return true;
    }

    private void goToLastPage() {
        if (page != 1) {
            page--;
            updateBook();
        }
    }

    private void goToNextPage() {
        if (page != maxPage) {
            page++;
            updateBook();
        }
    }

    private void updateBook() {
        MinecraftClient.getInstance().openScreen(null);
        MinecraftClient.getInstance().openScreen(new HelpBookScreen(page));
    }

    private Identifier getPage(byte page) {
        return new Identifier("aier","textures/gui/page_" + page + ".png");
    }
}