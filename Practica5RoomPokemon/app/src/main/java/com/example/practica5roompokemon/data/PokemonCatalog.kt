package com.example.practica5roompokemon.data

import java.text.Normalizer
import kotlin.random.Random

enum class PokemonRarity {
    COMMON, UNCOMMON, RARE, LEGENDARY
}

data class PokemonCatalogEntry(
    val dexNumber: Int,
    val name: String,
    val type: String,
    val secondaryType: String? = null,
    val rarity: PokemonRarity = PokemonRarity.COMMON
)

object PokemonCatalog {

    val pokemonList = listOf(
        PokemonCatalogEntry(1, "Bulbasaur", "Planta", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(2, "Ivysaur", "Planta", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(3, "Venusaur", "Planta", "Veneno", PokemonRarity.RARE),
        PokemonCatalogEntry(4, "Charmander", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(5, "Charmeleon", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(6, "Charizard", "Fuego", "Volador", PokemonRarity.RARE),
        PokemonCatalogEntry(7, "Squirtle", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(8, "Wartortle", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(9, "Blastoise", "Agua", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(10, "Caterpie", "Bicho"),
        PokemonCatalogEntry(11, "Metapod", "Bicho"),
        PokemonCatalogEntry(12, "Butterfree", "Bicho", "Volador", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(13, "Weedle", "Bicho"),
        PokemonCatalogEntry(14, "Kakuna", "Bicho"),
        PokemonCatalogEntry(15, "Beedrill", "Bicho", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(16, "Pidgey", "Normal", "Volador"),
        PokemonCatalogEntry(17, "Pidgeotto", "Normal", "Volador", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(18, "Pidgeot", "Normal", "Volador", PokemonRarity.RARE),
        PokemonCatalogEntry(19, "Rattata", "Normal"),
        PokemonCatalogEntry(20, "Raticate", "Normal", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(21, "Spearow", "Normal", "Volador"),
        PokemonCatalogEntry(22, "Fearow", "Normal", "Volador", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(23, "Ekans", "Veneno"),
        PokemonCatalogEntry(24, "Arbok", "Veneno", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(25, "Pikachu", "Eléctrico", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(26, "Raichu", "Eléctrico", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(27, "Sandshrew", "Tierra"),
        PokemonCatalogEntry(28, "Sandslash", "Tierra", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(29, "Nidoran F", "Veneno"),
        PokemonCatalogEntry(30, "Nidorina", "Veneno", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(31, "Nidoqueen", "Veneno", "Tierra", PokemonRarity.RARE),
        PokemonCatalogEntry(32, "Nidoran M", "Veneno"),
        PokemonCatalogEntry(33, "Nidorino", "Veneno", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(34, "Nidoking", "Veneno", "Tierra", PokemonRarity.RARE),
        PokemonCatalogEntry(35, "Clefairy", "Hada", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(36, "Clefable", "Hada", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(37, "Vulpix", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(38, "Ninetales", "Fuego", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(39, "Jigglypuff", "Normal", "Hada", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(40, "Wigglytuff", "Normal", "Hada", PokemonRarity.RARE),
        PokemonCatalogEntry(41, "Zubat", "Veneno", "Volador"),
        PokemonCatalogEntry(42, "Golbat", "Veneno", "Volador", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(43, "Oddish", "Planta", "Veneno"),
        PokemonCatalogEntry(44, "Gloom", "Planta", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(45, "Vileplume", "Planta", "Veneno", PokemonRarity.RARE),
        PokemonCatalogEntry(46, "Paras", "Bicho", "Planta"),
        PokemonCatalogEntry(47, "Parasect", "Bicho", "Planta", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(48, "Venonat", "Bicho", "Veneno"),
        PokemonCatalogEntry(49, "Venomoth", "Bicho", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(50, "Diglett", "Tierra"),
        PokemonCatalogEntry(51, "Dugtrio", "Tierra", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(52, "Meowth", "Normal"),
        PokemonCatalogEntry(53, "Persian", "Normal", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(54, "Psyduck", "Agua"),
        PokemonCatalogEntry(55, "Golduck", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(56, "Mankey", "Lucha"),
        PokemonCatalogEntry(57, "Primeape", "Lucha", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(58, "Growlithe", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(59, "Arcanine", "Fuego", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(60, "Poliwag", "Agua"),
        PokemonCatalogEntry(61, "Poliwhirl", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(62, "Poliwrath", "Agua", "Lucha", PokemonRarity.RARE),
        PokemonCatalogEntry(63, "Abra", "Psíquico", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(64, "Kadabra", "Psíquico", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(65, "Alakazam", "Psíquico", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(66, "Machop", "Lucha"),
        PokemonCatalogEntry(67, "Machoke", "Lucha", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(68, "Machamp", "Lucha", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(69, "Bellsprout", "Planta", "Veneno"),
        PokemonCatalogEntry(70, "Weepinbell", "Planta", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(71, "Victreebel", "Planta", "Veneno", PokemonRarity.RARE),
        PokemonCatalogEntry(72, "Tentacool", "Agua", "Veneno"),
        PokemonCatalogEntry(73, "Tentacruel", "Agua", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(74, "Geodude", "Roca", "Tierra"),
        PokemonCatalogEntry(75, "Graveler", "Roca", "Tierra", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(76, "Golem", "Roca", "Tierra", PokemonRarity.RARE),
        PokemonCatalogEntry(77, "Ponyta", "Fuego"),
        PokemonCatalogEntry(78, "Rapidash", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(79, "Slowpoke", "Agua", "Psíquico"),
        PokemonCatalogEntry(80, "Slowbro", "Agua", "Psíquico", PokemonRarity.RARE),
        PokemonCatalogEntry(81, "Magnemite", "Eléctrico"),
        PokemonCatalogEntry(82, "Magneton", "Eléctrico", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(83, "Farfetchd", "Normal", "Volador", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(84, "Doduo", "Normal", "Volador"),
        PokemonCatalogEntry(85, "Dodrio", "Normal", "Volador", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(86, "Seel", "Agua"),
        PokemonCatalogEntry(87, "Dewgong", "Agua", "Hielo", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(88, "Grimer", "Veneno"),
        PokemonCatalogEntry(89, "Muk", "Veneno", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(90, "Shellder", "Agua"),
        PokemonCatalogEntry(91, "Cloyster", "Agua", "Hielo", PokemonRarity.RARE),
        PokemonCatalogEntry(92, "Gastly", "Fantasma", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(93, "Haunter", "Fantasma", "Veneno", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(94, "Gengar", "Fantasma", "Veneno", PokemonRarity.RARE),
        PokemonCatalogEntry(95, "Onix", "Roca", "Tierra", PokemonRarity.RARE),
        PokemonCatalogEntry(96, "Drowzee", "Psíquico"),
        PokemonCatalogEntry(97, "Hypno", "Psíquico", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(98, "Krabby", "Agua"),
        PokemonCatalogEntry(99, "Kingler", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(100, "Voltorb", "Eléctrico"),
        PokemonCatalogEntry(101, "Electrode", "Eléctrico", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(102, "Exeggcute", "Planta", "Psíquico"),
        PokemonCatalogEntry(103, "Exeggutor", "Planta", "Psíquico", PokemonRarity.RARE),
        PokemonCatalogEntry(104, "Cubone", "Tierra", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(105, "Marowak", "Tierra", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(106, "Hitmonlee", "Lucha", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(107, "Hitmonchan", "Lucha", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(108, "Lickitung", "Normal", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(109, "Koffing", "Veneno"),
        PokemonCatalogEntry(110, "Weezing", "Veneno", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(111, "Rhyhorn", "Tierra", "Roca", PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(112, "Rhydon", "Tierra", "Roca", PokemonRarity.RARE),
        PokemonCatalogEntry(113, "Chansey", "Normal", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(114, "Tangela", "Planta", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(115, "Kangaskhan", "Normal", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(116, "Horsea", "Agua"),
        PokemonCatalogEntry(117, "Seadra", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(118, "Goldeen", "Agua"),
        PokemonCatalogEntry(119, "Seaking", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(120, "Staryu", "Agua"),
        PokemonCatalogEntry(121, "Starmie", "Agua", "Psíquico", PokemonRarity.RARE),
        PokemonCatalogEntry(122, "Mr Mime", "Psíquico", "Hada", PokemonRarity.RARE),
        PokemonCatalogEntry(123, "Scyther", "Bicho", "Volador", PokemonRarity.RARE),
        PokemonCatalogEntry(124, "Jynx", "Hielo", "Psíquico", PokemonRarity.RARE),
        PokemonCatalogEntry(125, "Electabuzz", "Eléctrico", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(126, "Magmar", "Fuego", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(127, "Pinsir", "Bicho", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(128, "Tauros", "Normal", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(129, "Magikarp", "Agua"),
        PokemonCatalogEntry(130, "Gyarados", "Agua", "Volador", PokemonRarity.RARE),
        PokemonCatalogEntry(131, "Lapras", "Agua", "Hielo", PokemonRarity.RARE),
        PokemonCatalogEntry(132, "Ditto", "Normal", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(133, "Eevee", "Normal", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(134, "Vaporeon", "Agua", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(135, "Jolteon", "Eléctrico", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(136, "Flareon", "Fuego", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(137, "Porygon", "Normal", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(138, "Omanyte", "Roca", "Agua", PokemonRarity.RARE),
        PokemonCatalogEntry(139, "Omastar", "Roca", "Agua", PokemonRarity.RARE),
        PokemonCatalogEntry(140, "Kabuto", "Roca", "Agua", PokemonRarity.RARE),
        PokemonCatalogEntry(141, "Kabutops", "Roca", "Agua", PokemonRarity.RARE),
        PokemonCatalogEntry(142, "Aerodactyl", "Roca", "Volador", PokemonRarity.RARE),
        PokemonCatalogEntry(143, "Snorlax", "Normal", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(144, "Articuno", "Hielo", "Volador", PokemonRarity.LEGENDARY),
        PokemonCatalogEntry(145, "Zapdos", "Eléctrico", "Volador", PokemonRarity.LEGENDARY),
        PokemonCatalogEntry(146, "Moltres", "Fuego", "Volador", PokemonRarity.LEGENDARY),
        PokemonCatalogEntry(147, "Dratini", "Dragón", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(148, "Dragonair", "Dragón", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(149, "Dragonite", "Dragón", "Volador", PokemonRarity.RARE),
        PokemonCatalogEntry(150, "Mewtwo", "Psíquico", rarity = PokemonRarity.LEGENDARY),
        PokemonCatalogEntry(151, "Mew", "Psíquico", rarity = PokemonRarity.LEGENDARY),
        PokemonCatalogEntry(152, "Chikorita", "Planta", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(153, "Bayleef", "Planta", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(154, "Meganium", "Planta", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(155, "Cyndaquil", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(156, "Quilava", "Fuego", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(157, "Typhlosion", "Fuego", rarity = PokemonRarity.RARE),
        PokemonCatalogEntry(158, "Totodile", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(159, "Croconaw", "Agua", rarity = PokemonRarity.UNCOMMON),
        PokemonCatalogEntry(160, "Feraligatr", "Agua", rarity = PokemonRarity.RARE)
    )

    private fun normalize(text: String): String {
        return Normalizer.normalize(text.trim().lowercase(), Normalizer.Form.NFD)
            .replace("\\p{InCombiningDiacriticalMarks}+".toRegex(), "")
            .replace(".", "")
            .replace("-", " ")
            .replace("♀", " f")
            .replace("♂", " m")
            .replace(Regex("\\s+"), " ")
    }

    private fun normalizeResourceName(text: String): String {
        return normalize(text)
            .replace(" ", "_")
            .replace(Regex("[^a-z0-9_]"), "")
    }

    fun findByName(input: String): PokemonCatalogEntry? {
        val normalizedInput = normalize(input)

        return pokemonList.firstOrNull { normalize(it.name) == normalizedInput }
            ?: when (normalizedInput) {
                "nidoranf", "nidoran f", "nidoran female" -> pokemonList.firstOrNull { it.dexNumber == 29 }
                "nidoranm", "nidoran m", "nidoran male" -> pokemonList.firstOrNull { it.dexNumber == 32 }
                "mr mime", "mrmime" -> pokemonList.firstOrNull { it.dexNumber == 122 }
                else -> null
            }
    }

    fun getPossibleImageNames(entry: PokemonCatalogEntry): List<String> {
        val padded3 = entry.dexNumber.toString().padStart(3, '0')
        val padded4 = entry.dexNumber.toString().padStart(4, '0')
        val raw = entry.dexNumber.toString()
        val normalizedName = normalizeResourceName(entry.name)

        return listOf(
            "p$padded3",          
            "p$padded4",
            "p$raw",
            "pokemon_$padded3",
            "pokemon_$padded4",
            "pokemon_$raw",
            normalizedName,
            "pokemon_$normalizedName"
        ).distinct()
    }

    fun generateLevel(entry: PokemonCatalogEntry): Int {
        return when (entry.rarity) {
            PokemonRarity.COMMON -> Random.nextInt(3, 16)
            PokemonRarity.UNCOMMON -> Random.nextInt(10, 26)
            PokemonRarity.RARE -> Random.nextInt(22, 46)
            PokemonRarity.LEGENDARY -> Random.nextInt(50, 81)
        }
    }

    fun calculateCaptureChance(
        rarity: PokemonRarity,
        level: Int,
        attempts: Int
    ): Double {
        val base = when (rarity) {
            PokemonRarity.COMMON -> 0.70
            PokemonRarity.UNCOMMON -> 0.52
            PokemonRarity.RARE -> 0.28
            PokemonRarity.LEGENDARY -> 0.08
        }

        val levelPenalty = (level - 1) * 0.005
        val retryBonus = attempts * 0.08

        return (base - levelPenalty + retryBonus).coerceIn(0.05, 0.95)
    }
}