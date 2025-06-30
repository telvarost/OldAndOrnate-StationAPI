# OldAndOrnate StationAPI for Minecraft Beta 1.7.3

A StationAPI mod for Minecraft Beta 1.7.3 that adds in a few small old features and other random ornate addons.
- Requires [Zastavka API](https://modrinth.com/mod/zastavkaapi) (used to freeze/chill enemies when hit with the Lapis Lazuli Sword)

# Old and Ornate
Mod now works on Multiplayer with GlassConfigAPI version 3.0+ used to sync configs!

### Adobe Features
Adds adobe blocks, recipes, and terrain generation (ported from mod archive and enhanced with configs)
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
  * Decorative but weaker brick block
  * 2 crafting recipe choices (default crafting recipe enabled):
    * Disable the crafting recipe
    * Craft 4 Adobe Brick in a square
* Special config to generate adobe lakebeds in savanna biomes (default enabled)
  * Also, lowers normal lake spawn chance in savannas (effectively swapping some water lakes for dry adobe lakebeds)
* Special config that tweaks adobe/adobe bricks mining speed (default enabled)
  * Makes Adobe mine slower than dirt (and slower than the old mod)
  * Makes Adobe Bricks mine faster than stone (and faster than the old mod)

### Dungeon Platform Features
Adds dungeon platform block and recipe
* Dungeon Platform
  * Platform that falls when touched by a player and regenerates
    * When touched by a player the dungeon platform becomes a faltering platform that falls after 6 seconds
    * After the faltering platform falls it becomes a ghost platform that players will fall through but monsters can walk on
      * Faltering platforms do not produce blocks when they land
    * The ghost platform turns back into a dungeon platform after 6 seconds
  * Craft 2 obsidian with 2 soul sand to get 4 dungeon platforms (recipe enabled by default)
    * Recipe is a square and blocks must be diagonal from each other
* Special config to generate unique bipyramid creeper dungeons in the sky dimension (default enabled)
  * Compatible with Elemental Creepers mod and Music Discs mod (both assist in creating greater dungeon variety)
  * NOTE: TNT in these dungeons is set to explode when punched, so be careful! (spawns rarely)

### Star Flower Features
Adds star flower block, recipes, and terrain generation (ported from mod archive and enhanced with configs)
* Star Flower
  * Flower that glows faintly
  * Craft 1 glowstone dust with 1 dandelion to get 1 star flower (recipe enabled by default)
  * Craft 1 star flower to get 2 lime dye (recipe enabled by default)
* Special config to limit terrain generation to specific biomes or to disable it entirely (specific biomes selected by default)
  * When specific biomes is selected, star flowers will only generate in the shrubland, seasonal forest, swampland, and tundra biomes
  * Separate config available for enabling/disabling star flower terrain generation in the sky dimension (default enabled)

### Other Features
Adds some other small new add-ons!
* Furnace Minecart Theme Song
  * The furnace minecart will now play a song when charcoal is used to power it (default enabled)
    * The song will not play if a jukebox is playing a disc
    * The song will end if any nearby furnace minecart is destroyed
* Lapis Lazuli Sword
  * A weak sword made from a deep blue rock locked in time under the earth
    * On hit chills enemies for 1 second (potentially freezing them for 0.75 seconds)
      * Unsheared sheep are immune to the chilling/freezing effect because of their thick wool coats
    * Has 64 durability, half the attack of a wooden/gold sword, and the mining speed of a wooden sword
  * Craft 2 lapis lazuli and 1 stick using the normal sword crafting shape (recipe enabled by default)

### Default Recipes
![default adobe craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/DefaultAdobeRecipe.png)
![default adobe brick smelt recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/DefaultAdobeBrickRecipe.png)
![adobe bricks craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/AdobeBricksRecipe.png)
![star flower craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/StarFlowerCraftingRecipe.png)
![star flower dye craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/StarFlowerDyeRecipe.png)
![lapis lazuli sword craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/LapisLazuliSwordRecipe.png)
![dungeon platform craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/DungeonPlatformRecipe.png)

### Alternate Recipes
![alternate adobe craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/AlternateAdobeRecipe.png)
![alternate adobe brick craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/AlternateAdobeBrickRecipe.png)

### Alternate Recipes (Realism)
![realism adobe craft recipe](https://github.com/telvarost/OldAndOrnate-StationAPI/blob/main/images/RealismAdobeRecipe.png)

## Installation using Prism Launcher

1. Download an instance of Babric for Prism Launcher: https://github.com/Glass-Series/babric-prism-instance
2. Install Java 17 and set the instance to use it: https://adoptium.net/temurin/releases/
3. Add GlassConfigAPI 3.0.2+ to the mod folder for the instance: https://modrinth.com/mod/glass-config-api
4. Add Glass Networking to the mod folder for the instance: https://modrinth.com/mod/glass-networking
5. Add StationAPI to the mod folder for the instance: https://modrinth.com/mod/stationapi
6. Add ZastavkaAPI to the mod folder for the instance: https://modrinth.com/mod/zastavkaapi
7. (Optional) Add Mod Menu to the mod folder for the instance: https://modrinth.com/mod/modmenu-beta
8. Add this mod to the mod folder for the instance: https://github.com/telvarost/OldAndOrnate-StationAPI/releases
9. Run and enjoy! 👍

## Feedback

Got any suggestions on what should be added next? Feel free to share it by [creating an issue](https://github.com/telvarost/OldAndOrnate-StationAPI/issues/new). Know how to code and want to do it yourself? Then look below on how to get started.

## Contributing

Thanks for considering contributing! To get started fork this repository, make your changes, and create a PR. 

If you are new to StationAPI consider watching the following videos on Babric/StationAPI Minecraft modding: https://www.youtube.com/watch?v=9-sVGjnGJ5s&list=PLa2JWzyvH63wGcj5-i0P12VkJG7PDyo9T
