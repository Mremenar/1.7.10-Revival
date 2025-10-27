// === Dimension Portal placeholders (blocks + items) ===
// Utopia
public static final RegistryObject<Block> UTOPIA_PORTAL = BLOCKS.register("utopia_portal",
        () -> new com.example.orespawn.portal.SimplePortalBlock(net.minecraft.world.level.block.state.BlockBehaviour.Properties.of().strength(3.0f)));
public static final RegistryObject<Item> UTOPIA_IGNITER = ITEMS.register("utopia_igniter",
        () -> new com.example.orespawn.portal.PortalIgniterItem(new Item.Properties()));

// Farming
public static final RegistryObject<Block> FARMING_PORTAL = BLOCKS.register("farming_portal",
        () -> new com.example.orespawn.portal.SimplePortalBlock(net.minecraft.world.level.block.state.BlockBehaviour.Properties.of().strength(3.0f)));
public static final RegistryObject<Item> FARMING_IGNITER = ITEMS.register("farming_igniter",
        () -> new com.example.orespawn.portal.PortalIgniterItem(new Item.Properties()));
