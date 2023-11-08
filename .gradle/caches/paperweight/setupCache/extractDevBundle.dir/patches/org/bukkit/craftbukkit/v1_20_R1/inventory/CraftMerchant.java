package org.bukkit.craftbukkit.v1_20_R1.inventory;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.List;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffers;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Merchant;
import org.bukkit.inventory.MerchantRecipe;

public class CraftMerchant implements Merchant {

    protected final net.minecraft.world.item.trading.Merchant merchant;

    public CraftMerchant(net.minecraft.world.item.trading.Merchant merchant) {
        this.merchant = merchant;
    }

    public net.minecraft.world.item.trading.Merchant getMerchant() {
        return this.merchant;
    }

    @Override
    public List<MerchantRecipe> getRecipes() {
        return List.copyOf(Lists.transform(this.merchant.getOffers(), new Function<net.minecraft.world.item.trading.MerchantOffer, MerchantRecipe>() { // Paper - javadoc says 'an immutable list of trades' - not 'an unmodifiable view of a list of trades'. fixes issue with setRecipes(getRecipes())
            @Override
            public MerchantRecipe apply(net.minecraft.world.item.trading.MerchantOffer recipe) {
                return recipe.asBukkit();
            }
        }));
    }

    @Override
    public void setRecipes(List<MerchantRecipe> recipes) {
        MerchantOffers recipesList = this.merchant.getOffers();
        recipesList.clear();
        for (MerchantRecipe recipe : recipes) {
            recipesList.add(CraftMerchantRecipe.fromBukkit(recipe).toMinecraft());
        }
    }

    @Override
    public MerchantRecipe getRecipe(int i) {
        return this.merchant.getOffers().get(i).asBukkit();
    }

    @Override
    public void setRecipe(int i, MerchantRecipe merchantRecipe) {
        this.merchant.getOffers().set(i, CraftMerchantRecipe.fromBukkit(merchantRecipe).toMinecraft());
    }

    @Override
    public int getRecipeCount() {
        return this.merchant.getOffers().size();
    }

    @Override
    public boolean isTrading() {
        return this.getTrader() != null;
    }

    @Override
    public HumanEntity getTrader() {
        Player eh = this.merchant.getTradingPlayer();
        return eh == null ? null : eh.getBukkitEntity();
    }

    @Override
    public int hashCode() {
        return this.merchant.hashCode();
    }

    @Override
    public boolean equals(final Object obj) {
        return obj instanceof CraftMerchant && ((CraftMerchant) obj).merchant.equals(this.merchant);
    }
}
