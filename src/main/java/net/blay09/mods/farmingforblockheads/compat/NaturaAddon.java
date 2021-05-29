package net.blay09.mods.farmingforblockheads.compat;

import net.blay09.mods.farmingforblockheads.api.FarmingForBlockheadsAPI;
import net.blay09.mods.farmingforblockheads.api.IMarketRegistryDefaultHandler;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;

public class NaturaAddon {

    private static final String KEY_SAPLINGS = "Natura Saplings";
    private static final String KEY_BUSHES = "Natura Bushes";
    private static final String KEY_NETHER_BUSHES = "Natura Nether Bushes";
    private static final String KEY_SEEDS = "Natura Seeds";

    public NaturaAddon() {
        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_SEEDS, new IMarketRegistryDefaultHandler() {
            @Override
            public void register(@Nullable ItemStack overridePayment, @Nullable Integer overrideCount) {
                final String[] SEEDS = new String[]{"overworld_seeds"};

                ItemStack effectivePayment = overridePayment;
                if(effectivePayment == null) {
                    effectivePayment = getDefaultPayment();
                }

                for (String SEED : SEEDS) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, SEED);
                    if (ForgeRegistries.ITEMS.containsKey(location)) {
                        Item itemSeed = ForgeRegistries.ITEMS.getValue(location);
                        for (int j = 0; j <= 1; j++) {
                            ItemStack seedStack = new ItemStack(itemSeed, overrideCount != null ? overrideCount : 1);
                            FarmingForBlockheadsAPI.registerMarketEntry(seedStack, effectivePayment, FarmingForBlockheadsAPI.getMarketCategorySeeds());
                        }
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_SAPLINGS, new IMarketRegistryDefaultHandler() {
            @Override
            public void register(@Nullable ItemStack overridePayment, @Nullable Integer overrideCount) {
                final String[] SAPLINGS = new String[]{"overworld_sapling", "overworld_sapling2", "redwood_sapling"};

                ItemStack effectivePayment = overridePayment;
                if(effectivePayment == null) {
                    effectivePayment = getDefaultPayment();
                }

                for (int i = 0; i < SAPLINGS.length; i++) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, SAPLINGS[i]);
                    if (ForgeRegistries.BLOCKS.containsKey(location)) {
                        Block blockSapling = ForgeRegistries.BLOCKS.getValue(location);
                        for (int j = 0; j < (i == 2 ? 1 : 4); j++) {
                            ItemStack saplingStack = new ItemStack(blockSapling, overrideCount != null ? overrideCount : 1);
                            FarmingForBlockheadsAPI.registerMarketEntry(saplingStack, effectivePayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                        }
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_BUSHES, new IMarketRegistryDefaultHandler() {
            @Override
            public void register(@Nullable ItemStack overridePayment, @Nullable Integer overrideCount) {
                final String[] BUSHES = new String[]{"overworld_berrybush_raspberry", "overworld_berrybush_blueberry", "overworld_berrybush_blackberry", "overworld_berrybush_maloberry"};

                ItemStack effectivePayment = overridePayment;
                if(effectivePayment == null) {
                    effectivePayment = getDefaultPayment();
                }

                for (String BUSH : BUSHES) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, BUSH);
                    if (ForgeRegistries.BLOCKS.containsKey(location)) {
                        Block blockBush = ForgeRegistries.BLOCKS.getValue(location);
                        ItemStack bushStack = new ItemStack(blockBush, overrideCount != null ? overrideCount : 1);
                        FarmingForBlockheadsAPI.registerMarketEntry(bushStack, effectivePayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD, 2);
            }
        });

        FarmingForBlockheadsAPI.registerMarketDefaultHandler(KEY_NETHER_BUSHES, new IMarketRegistryDefaultHandler() {
            @Override
            public void register(@Nullable ItemStack overridePayment, @Nullable Integer overrideCount) {
                final String[] BUSHES = new String[]{"nether_berrybush_blightberry", "nether_berrybush_duskberry", "nether_berrybush_skyberry", "nether_berrybush_stingberry"};

                ItemStack effectivePayment = overridePayment;
                if(effectivePayment == null) {
                    effectivePayment = getDefaultPayment();
                }

                for (String BUSH : BUSHES) {
                    ResourceLocation location = new ResourceLocation(Compat.NATURA, BUSH);
                    if (ForgeRegistries.BLOCKS.containsKey(location)) {
                        Block blockBush = ForgeRegistries.BLOCKS.getValue(location);
                        ItemStack bushStack = new ItemStack(blockBush, overrideCount != null ? overrideCount : 1);
                        FarmingForBlockheadsAPI.registerMarketEntry(bushStack, effectivePayment, FarmingForBlockheadsAPI.getMarketCategorySaplings());
                    }
                }
            }

            @Override
            public boolean isEnabledByDefault() {
                return true;
            }

            @Override
            public ItemStack getDefaultPayment() {
                return new ItemStack(Items.EMERALD, 3);
            }
        });
    }

}
