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
    private final byte maxPage = 10;
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
            default:
                textRenderer1.draw(matrices, "§c*此页无效*", x + 62, y + 40, 0);
            case 1:
                //左
                textRenderer1.draw(matrices, "§l打败量子力学", x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "走上你的革命之路", x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "By: AmazingRabbit Studio", x + 24, y + 120, 0);
                textRenderer1.draw(matrices, "Special Thanks: OverRun Organization & mo_java30433", x + 24, y + 150, 0);
                textRenderer1.draw(matrices, "交流群:331998783", x + 24, y + 180, 0);
                //右
                break;
            case 2:
                textRenderer1.draw(matrices, "§l寒冰熔炉", x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "寒冰熔炉，可以以冰/雪/雪球/浮冰/蓝冰/黑冰等", x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "与冰雪相关的物品为燃料，同时可以将一种冰雪燃料" , x + 24, y + 106, 0);
                textRenderer1.draw(matrices, "烧制升级为能燃烧更长时间的燃料" , x + 24, y + 122, 0);
                textRenderer1.draw(matrices, "寒冰熔炉的燃烧速度比熔炉、烟熏炉和高炉都要快" , x + 24, y + 138, 0);
                textRenderer1.draw(matrices, "但是如果要大规模部署你将需要一个制冰工厂" , x + 24, y + 154, 0);
                break;
            case 3:
                textRenderer1.draw(matrices, "§l手摇粉碎机",x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "手摇粉碎机，可以在不使用燃料的情况下对物体进行粉碎",x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "燃料粉碎后由于接触面积变大，可以提升燃烧速度",x + 24, y + 106, 0);
                textRenderer1.draw(matrices, "手摇粉碎机只能将物体粉碎成大颗粒",x + 24, y + 122, 0);
                textRenderer1.draw(matrices, "要粉碎成小颗粒你需要粉碎机",x + 24, y + 138, 0);
                break;
            case 4:
                textRenderer1.draw(matrices, "§l压缩机",x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "压缩机，可以使用燃料把一组物品压缩成一个物品",x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "或者将几个物品压缩成一个更强大的物品",x + 24, y + 106, 0);
                textRenderer1.draw(matrices, "例一：",x + 24, y + 122, 0);
                textRenderer1.draw(matrices, "将一组圆石压缩成一个一重压缩圆石可以节省许多背包空间",x + 24, y + 138, 0);
                textRenderer1.draw(matrices, "在你要使用圆石时可以将它分解成一组圆石" , x + 24, y + 154, 0);
                textRenderer1.draw(matrices, "例二：" , x + 24, y + 170, 0);
                textRenderer1.draw(matrices, "将四块冰压缩可得到高热值冰" , x + 24, y + 186, 0);
                textRenderer1.draw(matrices, "高热值冰可以提升燃烧速度" , x + 24, y + 202, 0);
                break;
            case 5:
                textRenderer1.draw(matrices, "§l融合机",x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "融合机，可以使用燃料把两种物质熔化并形成合金锭",x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "合金锭制作的武器/装备等具有比金属金属更强的属性",x + 24, y + 106, 0);
                textRenderer1.draw(matrices, "所需燃料数量由参与合成的熔点最高的物质决定",x + 24, y + 122, 0);
                textRenderer1.draw(matrices, "熔点越高所需的燃料也就越多",x + 24, y + 138, 0);
                break;
            case 6:
                textRenderer1.draw(matrices, "§l塑造机",x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "塑造机，可以将一种形态的物质变为另一种形态",x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "需要铸模来塑形",x + 24, y + 106, 0);
                textRenderer1.draw(matrices, "所需燃料数量由物质的熔点决定",x + 24, y + 122, 0);
                textRenderer1.draw(matrices, "铸模上不能同时有两种及以上物质",x + 24, y + 138, 0);
                break;
            case 7:
                textRenderer1.draw(matrices, "§l能量灌注机",x + 62, y + 40, 0);
                textRenderer1.draw(matrices, "能量灌注机，可以将各种形式的能量灌注到物品里形成更强大的物品",x + 24, y + 90, 0);
                textRenderer1.draw(matrices, "如果将燃料燃烧时产生的内能灌注给不是用冰制作的物品",x + 24, y + 106, 0);
                textRenderer1.draw(matrices, "可以将此物品变为冰系物品",x + 24, y + 122, 0);
                textRenderer1.draw(matrices, "如果将黑色的物品中的黑暗能量灌注给物品",x + 24, y + 138, 0);
                textRenderer1.draw(matrices, "可以获得更强力但是可能有副作用的物品" , x + 24, y + 154, 0);
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
            page = 2;
            updateBook();
        }
        if(page-1 == 1) {
              page = 1;
            updateBook();
        }
    }

    private void goToNextPage() {
        if (page != maxPage) {
            if (page >= 1) {
                page = 2;
                updateBook();
            }
        }else{
            page = 1;
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