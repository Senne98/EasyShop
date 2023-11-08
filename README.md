# EasyShop
An API for creating shops

# Features
 - Different ways to sell/buy items (sell/buy one instantly or choose how much to sell/buy). More might be added in the future.
 - Works with CustomItemApi

# Requirements
 - Geld_API
 - CustomItemApi

# How to use
 - use the ````Shop```` class to make an interface.
 - use the ````SingleItem```` or ````Item```` class to make an Item you want to sell.
 - when creating an interface, you need to add  ````SingleItem````, ````Item````, ````Shop```` or ````null```` to the layout list (max size 54).
 - call ````Shop#openShop```` to open an interface.
