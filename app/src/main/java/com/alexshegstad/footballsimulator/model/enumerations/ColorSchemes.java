package com.alexshegstad.footballsimulator.model.enumerations;

public enum ColorSchemes {
   CRIMSON_GOLD("#8C1C13", "#FFD700", "#000000"),
   NAVY_SILVER("#0A2342", "#C0C0C0", "#FFFFFF"),
   ROYALBLUE_ORANGE("#0051BA", "#FF6600", "#FFFFFF"),
   GREEN_WHITE("#00843D", "#FFFFFF", "#101820"),
   BLACK_YELLOW("#101820", "#FFD100", "#FFFFFF"),
   MAROON_CREAM("#7B2D26", "#F5F5DC", "C5A46D"),
   TEAL_BLACK("#006D77", "#101820", "#A7A7A7"),
   PURPLE_GOLD("#4B0082", "FFCC00", "#FFFFFF"),
   RED_BLACK("C8102E", "#000000", "#FFFFFF"),
   SKYBLUE_NAVY("#87CEEB", "#000000", "#FFFFFF"),
   ORANGE_BROWN("#D35400", "#4E342E", "#FFFFFF"),
   FORESTGREEN_GOLD("#013220", "#FFD700", "#FFFFFF"),
   TURQUOISE_WHITE("#40E0D0", "#FFFFFF", "#333333"),
   SCARLET_GRAY("#BB0000", "#888888", "#000000"),
   MIDNIGHTBLUE_NEONGREEN("#003366", "#39FF14", "#A9A9A9"),
   COPPER_BLACK("#B87333", "#101820", "#FFFFFF"),
   BURGUNDY_GOLD("#800020", "#DAA520", "#FFFFFF"),
   CYAN_CHARCOAL("#00BCD4", "#36454F", "#FFFFFF"),
   MAGENTA_BLACK("#E20074", "#101820", "#B0B0B0"),
   BROWN_YELLOW("#8B4513", "#FFD34E", "FFFFFF"),
   DARKPURPLE_SILVER("#301934", "#C0C0C0", "#000000"),
   REDORANGE_NAVY("#E34234", "#0A2342", "#FFFFFF"),
   OLIVEGREEN_TAN("#808000", "#D2B48C", "#FFFFFF"),
   ICEBLUE_BLACK("#A9D6E5", "#101820", "#FFFFFF"),
   PINK_GRAY("#FF69B4", "#808080", "#FFFFFF"),
   DARKTEAL_ORANGE("#014D4E", "#FF6F3C", "#FFFFFF"),
   INDIGIO_WHITE("#4B0082", "#FFFFFF", "#C0C0C0"),
   DARKRED_CREAM("#8B0000", "#FFFDD0", "#000000"),
   STEELBLUE_BRONZE("#4682B4", "#CD7F32", "#FFFFFF"),
   CHARCOAL_NEONYELLOW("#2F4F4F", "#DFFF00", "#000000");

   private final String colorCode1;
   private final String colorCode2;
   private final String colorCode3;

   ColorSchemes(String colorCode1, String colorCode2, String colorCode3) {
    this.colorCode1 = colorCode1;
    this.colorCode2 = colorCode2;
    this.colorCode3 = colorCode3;
   }

   public String[] getColorScheme() {
    String colorCodes[] = {colorCode1, colorCode2, colorCode3};
    return colorCodes;
   }

   @Override
   public String toString() {
        return colorCode1 + ", " + colorCode2 + ", " + colorCode3 + ".";
   }
}

/*
Crimson & Gold – Crimson (#8C1C13), Metallic Gold (#FFD700), Black (#000000)

Navy & Silver – Navy (#0A2342), Silver (#C0C0C0), White (#FFFFFF)

Royal Blue & Orange – Royal Blue (#0051BA), Bright Orange (#FF6600), White (#FFFFFF)

Green & White – Kelly Green (#00843D), White (#FFFFFF), Black (#101820)

Black & Yellow – Jet Black (#101820), Yellow (#FFD100), White (#FFFFFF)

Maroon & Cream – Maroon (#7B2D26), Cream (#F5F5DC), Gold (#C5A46D)

Teal & Black – Teal (#006D77), Black (#101820), Silver (#A7A7A7)

Purple & Gold – Purple (#4B0082), Athletic Gold (#FFCC00), White (#FFFFFF)

Red & Black – Bright Red (#C8102E), Black (#000000), White (#FFFFFF)

Sky Blue & Navy – Sky Blue (#87CEEB), Navy (#003366), White (#FFFFFF)

Orange & Brown – Burnt Orange (#D35400), Chocolate Brown (#4E342E), White (#FFFFFF)

Forest Green & Gold – Dark Green (#013220), Gold (#FFD700), White (#FFFFFF)

Turquoise & White – Turquoise (#40E0D0), White (#FFFFFF), Dark Gray (#333333)

Scarlet & Gray – Scarlet (#BB0000), Medium Gray (#888888), Black (#000000)

Midnight Blue & Neon Green – Midnight Blue (#003366), Neon Green (#39FF14), Silver (#A9A9A9)

Copper & Black – Metallic Copper (#B87333), Black (#101820), White (#FFFFFF)

Burgundy & Gold – Burgundy (#800020), Rich Gold (#DAA520), White (#FFFFFF)

Cyan & Charcoal – Cyan (#00BCD4), Charcoal (#36454F), White (#FFFFFF)

Magenta & Black – Magenta (#E20074), Black (#101820), Silver (#B0B0B0)

Brown & Yellow – Saddle Brown (#8B4513), Mustard Yellow (#FFD34E), White (#FFFFFF)

Dark Purple & Silver – Deep Purple (#301934), Silver (#C0C0C0), Black (#000000)

Red-Orange & Navy – Vermilion (#E34234), Navy (#0A2342), White (#FFFFFF)

Olive Green & Tan – Olive (#808000), Tan (#D2B48C), White (#FFFFFF)

Ice Blue & Black – Ice Blue (#A9D6E5), Black (#101820), White (#FFFFFF)

Pink & Gray – Hot Pink (#FF69B4), Gray (#808080), White (#FFFFFF)

Dark Teal & Orange – Dark Teal (#014D4E), Sunset Orange (#FF6F3C), White (#FFFFFF)

Indigo & White – Indigo (#4B0082), White (#FFFFFF), Silver (#C0C0C0)

Dark Red & Cream – Dark Red (#8B0000), Cream (#FFFDD0), Black (#000000)

Steel Blue & Bronze – Steel Blue (#4682B4), Bronze (#CD7F32), White (#FFFFFF)

Charcoal & Neon Yellow – Charcoal (#2F4F4F), Neon Yellow (#DFFF00), Black (#000000)
*/

