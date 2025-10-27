// 
// Decompiled by Procyon v0.5.36
// 

package danger.orespawn;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.client.gui.FontRenderer;
import org.lwjgl.opengl.GL11;
import net.minecraft.block.material.Material;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class GirlfriendOverlayGui extends Gui
{
    private Minecraft mc;
    private static final ResourceLocation texture;
    
    public GirlfriendOverlayGui(final Minecraft mc) {
        this.mc = mc;
    }
    
    @SubscribeEvent
    public void onRenderOverlay(final RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.HOTBAR) {
            return;
        }
        final int u = 0;
        final int v = 0;
        String outstring = null;
        final int color = 16725044;
        final FontRenderer fr = this.mc.field_71466_p;
        final int barWidth = 182;
        final int barHeight = 5;
        float gfHealth = 0.0f;
        Entity entity = null;
        EntityPlayer player = null;
        if (this.mc.field_71474_y.field_74319_N || this.mc.field_71462_r != null) {
            return;
        }
        player = (EntityPlayer)this.mc.field_71439_g;
        if (player == null) {
            return;
        }
        OreSpawnMain.current_dimension = player.field_70170_p.field_73011_w.field_76574_g;
        if (this.mc.field_71474_y.field_74347_j) {
            OreSpawnMain.FastGraphicsLeaves = 0;
        }
        else {
            OreSpawnMain.FastGraphicsLeaves = 1;
        }
        if (OreSpawnMain.GuiOverlayEnable == 0) {
            return;
        }
        entity = this.mc.field_147125_j;
        if (entity == null) {
            entity = OreSpawnMain.getPointedAtEntity((World)this.mc.field_71441_e, player, 16.0);
            if (entity == null) {
                return;
            }
            if (!(entity instanceof EntityLivingBase)) {
                return;
            }
        }
        if (entity instanceof Girlfriend) {
            Girlfriend gf = null;
            gf = (Girlfriend)entity;
            if (!gf.func_152114_e((EntityLivingBase)player)) {
                return;
            }
            if (gf.passenger != 0) {
                return;
            }
            if (gf.func_94056_bM()) {
                outstring = gf.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Girlfriend";
            }
            gfHealth = gf.getGirlfriendHealth() / gf.func_110138_aP();
        }
        if (entity instanceof Boyfriend) {
            Boyfriend gf2 = null;
            gf2 = (Boyfriend)entity;
            if (!gf2.func_152114_e((EntityLivingBase)player)) {
                return;
            }
            if (gf2.passenger != 0) {
                return;
            }
            if (gf2.func_94056_bM()) {
                outstring = gf2.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Boyfriend";
            }
            gfHealth = gf2.getBoyfriendHealth() / gf2.func_110138_aP();
        }
        if (entity instanceof ThePrince) {
            ThePrince gf3 = null;
            gf3 = (ThePrince)entity;
            if (!gf3.func_152114_e((EntityLivingBase)player)) {
                return;
            }
            if (gf3.func_94056_bM()) {
                outstring = gf3.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Toddler Prince";
            }
            gfHealth = gf3.func_110143_aJ() / gf3.func_110138_aP();
        }
        if (entity instanceof ThePrincess) {
            ThePrincess gf4 = null;
            gf4 = (ThePrincess)entity;
            if (!gf4.func_152114_e((EntityLivingBase)player)) {
                return;
            }
            if (gf4.func_94056_bM()) {
                outstring = gf4.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Toddler Princess";
            }
            gfHealth = gf4.func_110143_aJ() / gf4.func_110138_aP();
        }
        if (entity instanceof ThePrinceTeen) {
            ThePrinceTeen gf5 = null;
            gf5 = (ThePrinceTeen)entity;
            if (!gf5.func_152114_e((EntityLivingBase)player)) {
                return;
            }
            if (gf5.func_94056_bM()) {
                outstring = gf5.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Young Prince";
            }
            if (gf5.getActivity() != 0) {
                return;
            }
            gfHealth = gf5.func_110143_aJ() / gf5.func_110138_aP();
        }
        if (entity instanceof ThePrinceAdult) {
            ThePrinceAdult gf6 = null;
            gf6 = (ThePrinceAdult)entity;
            if (!gf6.func_152114_e((EntityLivingBase)player)) {
                return;
            }
            if (gf6.func_94056_bM()) {
                outstring = gf6.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "The Young Adult Prince";
            }
            if (gf6.getActivity() != 0) {
                return;
            }
            gfHealth = gf6.func_110143_aJ() / gf6.func_110138_aP();
        }
        if (entity instanceof Dragon) {
            Dragon df = null;
            df = (Dragon)entity;
            if (df.func_94056_bM()) {
                outstring = df.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Dragon";
            }
            if (df.getActivity() != 0) {
                return;
            }
            gfHealth = df.getDragonHealth() / df.func_110138_aP();
        }
        if (entity instanceof EmperorScorpion) {
            final EmperorScorpion e = (EmperorScorpion)entity;
            outstring = "Emperor Scorpion";
            gfHealth = e.getEmperorScorpionHealth() / e.func_110138_aP();
        }
        if (entity instanceof Basilisk) {
            final Basilisk e2 = (Basilisk)entity;
            outstring = "Basilisk";
            gfHealth = e2.getBasiliskHealth() / e2.func_110138_aP();
        }
        if (entity instanceof Mothra) {
            final Mothra e3 = (Mothra)entity;
            outstring = "Mothra!";
            gfHealth = e3.getMothraHealth() / e3.func_110138_aP();
        }
        if (entity instanceof Spyro) {
            final Spyro e4 = (Spyro)entity;
            if (e4.func_94056_bM()) {
                outstring = e4.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Baby Dragon";
            }
            gfHealth = e4.getSpyroHealth() / e4.func_110138_aP();
        }
        if (entity instanceof WormLarge) {
            final WormLarge e5 = (WormLarge)entity;
            if (!e5.field_70145_X) {
                outstring = "Worm";
                gfHealth = e5.func_110143_aJ() / e5.func_110138_aP();
            }
        }
        if (entity instanceof Alien) {
            final Alien e6 = (Alien)entity;
            outstring = "Alien!";
            gfHealth = e6.getAlienHealth() / e6.func_110138_aP();
        }
        if (entity instanceof WaterDragon) {
            final WaterDragon e7 = (WaterDragon)entity;
            if (e7.func_94056_bM()) {
                outstring = e7.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "WaterDragon";
            }
            gfHealth = e7.getWaterDragonHealth() / e7.func_110138_aP();
        }
        if (entity instanceof Kraken) {
            final Kraken e8 = (Kraken)entity;
            outstring = "Kraken";
            gfHealth = e8.getKrakenHealth() / e8.func_110138_aP();
        }
        if (entity instanceof Cephadrome) {
            final Cephadrome e9 = (Cephadrome)entity;
            outstring = "Cephadrome";
            gfHealth = e9.getCephadromeHealth() / e9.func_110138_aP();
            if (e9.getActivity() != 0) {
                return;
            }
        }
        if (entity instanceof TrooperBug) {
            final TrooperBug e10 = (TrooperBug)entity;
            outstring = "Jumpy Bug";
            gfHealth = e10.getTrooperBugHealth() / e10.func_110138_aP();
        }
        if (entity instanceof SpitBug) {
            final SpitBug e11 = (SpitBug)entity;
            outstring = "Spit Bug";
            gfHealth = e11.func_110143_aJ() / e11.func_110138_aP();
        }
        if (entity instanceof PitchBlack) {
            final PitchBlack e12 = (PitchBlack)entity;
            outstring = "Nightmare";
            gfHealth = e12.func_110143_aJ() / e12.func_110138_aP();
        }
        if (entity instanceof Alosaurus) {
            final Alosaurus e13 = (Alosaurus)entity;
            outstring = "Alosaurus";
            gfHealth = e13.func_110143_aJ() / e13.func_110138_aP();
        }
        if (entity instanceof Nastysaurus) {
            final Nastysaurus e14 = (Nastysaurus)entity;
            outstring = "Nastysaurus";
            gfHealth = e14.func_110143_aJ() / e14.func_110138_aP();
        }
        if (entity instanceof TRex) {
            final TRex e15 = (TRex)entity;
            outstring = "T. Rex";
            gfHealth = e15.func_110143_aJ() / e15.func_110138_aP();
        }
        if (entity instanceof Kyuubi) {
            final Kyuubi e16 = (Kyuubi)entity;
            outstring = "Kyuubi";
            gfHealth = e16.func_110143_aJ() / e16.func_110138_aP();
        }
        if (entity instanceof Robot2) {
            final Robot2 e17 = (Robot2)entity;
            outstring = "Robo-Pounder";
            gfHealth = e17.func_110143_aJ() / e17.func_110138_aP();
        }
        if (entity instanceof Robot4) {
            final Robot4 e18 = (Robot4)entity;
            outstring = "Robo-Warrior";
            gfHealth = e18.getRobot4Health() / e18.func_110138_aP();
        }
        if (entity instanceof Triffid) {
            final Triffid e19 = (Triffid)entity;
            outstring = "Triffid";
            gfHealth = e19.func_110143_aJ() / e19.func_110138_aP();
        }
        if (entity instanceof Godzilla) {
            final Godzilla e20 = (Godzilla)entity;
            outstring = "Mobzilla";
            gfHealth = e20.func_110143_aJ() / e20.func_110138_aP();
        }
        if (entity instanceof Vortex) {
            final Vortex e21 = (Vortex)entity;
            outstring = "Vortex";
            gfHealth = e21.func_110143_aJ() / e21.func_110138_aP();
        }
        if (entity instanceof Irukandji) {
            final Irukandji e22 = (Irukandji)entity;
            outstring = "Irukandji";
            gfHealth = e22.func_110143_aJ() / e22.func_110138_aP();
        }
        if (entity instanceof Mantis) {
            final Mantis e23 = (Mantis)entity;
            outstring = "Mantis";
            gfHealth = e23.func_110143_aJ() / e23.func_110138_aP();
        }
        if (entity instanceof HerculesBeetle) {
            final HerculesBeetle e24 = (HerculesBeetle)entity;
            outstring = "Hercules Beetle";
            gfHealth = e24.func_110143_aJ() / e24.func_110138_aP();
        }
        if (entity instanceof TheKing) {
            final TheKing e25 = (TheKing)entity;
            outstring = "The King";
            gfHealth = e25.func_110143_aJ() / e25.func_110138_aP();
        }
        if (entity instanceof TheQueen) {
            final TheQueen e26 = (TheQueen)entity;
            outstring = "The Queen";
            gfHealth = e26.func_110143_aJ() / e26.func_110138_aP();
        }
        if (entity instanceof SeaViper) {
            final SeaViper e27 = (SeaViper)entity;
            outstring = "Sea Viper";
            gfHealth = e27.func_110143_aJ() / e27.func_110138_aP();
        }
        if (entity instanceof SeaMonster) {
            final SeaMonster e28 = (SeaMonster)entity;
            outstring = "Sea Monster";
            gfHealth = e28.func_110143_aJ() / e28.func_110138_aP();
        }
        if (entity instanceof Molenoid) {
            final Molenoid e29 = (Molenoid)entity;
            outstring = "Molenoid";
            gfHealth = e29.func_110143_aJ() / e29.func_110138_aP();
        }
        if (entity instanceof CaterKiller) {
            final CaterKiller e30 = (CaterKiller)entity;
            outstring = "CaterKiller";
            gfHealth = e30.func_110143_aJ() / e30.func_110138_aP();
        }
        if (entity instanceof Leon) {
            final Leon e31 = (Leon)entity;
            if (e31.func_94056_bM()) {
                outstring = e31.func_94057_bL();
            }
            if (outstring == null || outstring.equals("")) {
                outstring = "Leonopteryx";
            }
            gfHealth = e31.func_110143_aJ() / e31.func_110138_aP();
        }
        if (entity instanceof Hammerhead) {
            final Hammerhead e32 = (Hammerhead)entity;
            outstring = "Hammerhead";
            gfHealth = e32.func_110143_aJ() / e32.func_110138_aP();
        }
        if (entity instanceof BandP) {
            final BandP e33 = (BandP)entity;
            if (e33.getWhat() == 0) {
                outstring = "Banker";
            }
            else {
                outstring = "Politician";
            }
            gfHealth = e33.func_110143_aJ() / e33.func_110138_aP();
        }
        if (entity instanceof SpiderRobot) {
            final SpiderRobot e34 = (SpiderRobot)entity;
            outstring = "Giant Robot Spider";
            gfHealth = e34.func_110143_aJ() / e34.func_110138_aP();
        }
        if (entity instanceof GiantRobot) {
            final GiantRobot e35 = (GiantRobot)entity;
            outstring = "Jeffery";
            gfHealth = e35.func_110143_aJ() / e35.func_110138_aP();
        }
        if (entity instanceof AntRobot) {
            final AntRobot e36 = (AntRobot)entity;
            outstring = "Giant Robot Red Ant";
            gfHealth = e36.func_110143_aJ() / e36.func_110138_aP();
        }
        if (entity instanceof Crab) {
            final Crab e37 = (Crab)entity;
            final float myf = e37.getCrabScale();
            if (myf > 0.75f) {
                outstring = "Very Large Crab";
                gfHealth = e37.func_110143_aJ() / e37.func_110138_aP();
            }
        }
        if (outstring == null) {
            return;
        }
        final ScaledResolution res = new ScaledResolution(this.mc, this.mc.field_71443_c, this.mc.field_71440_d);
        final int width = res.func_78326_a();
        final int barWidthFilled = (int)(gfHealth * (barWidth + 1));
        final int x = width / 2 - barWidth / 2;
        int y = 25;
        if (player.func_70055_a(Material.field_151586_h) || player.func_70658_aO() > 0) {
            y -= 10;
        }
        fr.func_78261_a(outstring, width / 2 - fr.func_78256_a(outstring) / 2, y - 10, color);
        this.mc.field_71446_o.func_110577_a(GirlfriendOverlayGui.texture);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.func_73729_b(x, y, u, v, barWidth, barHeight);
        if (barWidthFilled > 0) {
            this.func_73729_b(x, y, u, v + barHeight, barWidthFilled, barHeight);
        }
    }
    
    static {
        texture = new ResourceLocation("orespawn", "girlfriendgui.png");
    }
}
