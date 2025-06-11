# OldAndOrnate StationAPI Edition for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 that adds in a few small old features and other random ornate addons.

# Old and Ornate
Mod now works on Multiplayer with GlassConfigAPI version 3.0+ used to sync configs!

### Features
* Adds adobe blocks and recipes (ported from mod archive)
  * Adobe (dirt/soil)
    * Special soil type that allows most plants to be planted on it, but doesn't allow them to grow
    * 4 crafting recipe choices (defaults to using new recipe):
      * Disable the crafting recipe
      * Old: Craft 1 Dirt -> Get 1 Adobe
      * New: Craft 1 Dirt and 1 Sand -> Get 2 Adobe
      * Realism: Craft 1 Dirt, 1 Sand, 1 Wheat, and 1 Water Bucket -> Get 4 Adobe
        * Water bucket is not consumed on craft
  * Adobe Brick
    * Item used to craft adobe bricks
    * 3 crafting recipe choices (defaults to using new recipe):
      * Disable the crafting recipe
      * Old: Craft 4 Adobe in a square
      * New: Smelt 1 Adobe
  * Adobe Bricks
    * Weaker brick block
    * 2 crafting recipe choices (default crafting recipe enabled):
      * Disable the crafting recipe
      * Craft 4 Adobe Brick in a square
  * Special config that tweaks adobe/adobe bricks mining speed (default enabled)
    * Makes Adobe mine slower than dirt (and slower than the old mod)
    * Makes Adobe Bricks mine faster than stone (and faster than the old mod)
* Adds star flower block and terrain generation (ported from mod archive)
  * Star Flower
    * Flower that glows faintly
    * Craft 1 glowstone dust with 1 dandelion to get 1 star flower (recipe enabled by default)
    * Craft 1 star flower to get 2 lime dye (recipe enabled by default)
    * Special config to limit terrain generation to specific biomes or to disable it entirely
      * When specific biomes is selected, star flowers will only generate in the shrubland, seasonal forest, swampland, and tundra

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/Glass-Series/babric-prism-instance
2. Install Java 17 and set the instance to use it: https://adoptium.net/temurin/releases/
3. Add GlassConfigAPI 3.0.2+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
4. Add Glass Networking to the mod folder for the instance: https://modrinth.com/mod/glass-networking
5. Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
6. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
7. Add this mod to the mod folder for the instance: https://github.com/telvarost/OldAndOrnate-StationAPI/releases
8. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/OldAndOrnate-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
