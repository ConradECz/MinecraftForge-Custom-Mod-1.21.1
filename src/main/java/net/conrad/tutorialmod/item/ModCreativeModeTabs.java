package net.conrad.tutorialmod.item;

import net.conrad.tutorialmod.TutorialMod;
import net.conrad.tutorialmod.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CONRAD_ITEMS_TAB =
            CREATIVE_MODE_TABS.register("conrad_items_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SMILEY_FACE.get()))
                            .title(Component.translatable("creativetab.tutorialmod.conrad_items"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModItems.SMILEY_FACE.get());
                                output.accept(ModItems.SAD_FACE.get());
                    }).build());

    public static final RegistryObject<CreativeModeTab> CONRAD_BLOCKS_TAB =
            CREATIVE_MODE_TABS.register("conrad_blocks_tab",
                    () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.KIELBASA_BLOCK.get()))
                            .withTabsBefore(CONRAD_ITEMS_TAB.getId())
                            .title(Component.translatable("creativetab.tutorialmod.conrad_blocks"))
                            .displayItems((itemDisplayParameters, output) -> {
                                output.accept(ModBlocks.KIELBASA_BLOCK.get());
                                output.accept(ModBlocks.USAGI_BLOCK.get());
                                output.accept(ModBlocks.MICHAELJORDAN_BLOCK.get());
                            }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
