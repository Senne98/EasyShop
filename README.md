</p>
   </p>
<p align="center">
    <a href="https://discord.gg/DBabnRZAhC" alt="join_Discord">
        <img src="https://img.shields.io/badge/-join_Discord-blue?logo=discord&style=flat&logoColor=white" /></a>
  </p>

</p>
   </p>
<p align="left">
    <a href="https://discord.gg/DBabnRZAhC" alt="join_Discord">
        <img src="https://cdn.modrinth.com/data/btkndQeC/images/f711c1883aa3faf2bb6b10ecdab0f6df76b0286b.png" width="350"/></a>
  </p>
An flexible plugin for creating gui shops with different templates.

# Features
 - Different templates for selling/buying items (Examples: sell/buy one instantly, open a menu to choose the amount you want to buy/sell).
 - Custom items created with Custom Item API

# Requirements
 - Geld_API
 - CustomItemApi

# How to use
 - Templates: ````SingleItem````, ````Item````, ````Shop````
 - Make a shop:
 1) use the ````Shop```` class to make an interface.
 2) use the ````SingleItem```` or ````Item```` class to make an Item you want to sell.
 3) when creating an interface, you need to add  ````SingleItem````, ````Item````, ````Shop```` or ````Empty```` to the layout list (max size 54).
 4) call ````Shop#openShop```` to open an interface.

# Planned features
The next large update will add an api that can be used to create your own templates. This will allow users to have much more unique shop functionality.
