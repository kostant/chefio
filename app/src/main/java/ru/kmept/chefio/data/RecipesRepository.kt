package ru.kmept.kormezhka.data

import ru.kmept.kormezhka.data.model.Recipe
import java.util.Date

class RecipesRepository {
    companion object {
        val global = RecipesRepository()
    }

    private val idGenerator = IdGenerator()
    private val usersRepository = UsersRepository()

    val mockFoodRecipes = arrayOf(
        Recipe(
            id = idGenerator.next(),
            name = "Chopped Power Salad with Chicken",
            author = usersRepository.random(),
            duration = 60,
            pictureUrl = "https://www.eatingwell.com/thmb/gbn0y2H8YW_TYA0GPaW2cRiEblI=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/chopped-power-salad-with-chicken-0ad93f1931524a679c0f8854d74e6e57.jpg",
            description = "Здесь будет описание",
            likesCount = (0..1000).random(),
            createdAt = Date(2024, (0..4).random(), (0..28).random())
        ),
        Recipe(
            id = idGenerator.next(),
            name = "Cabbage Caesar Salad",
            author = usersRepository.random(),
            duration = 60,
            pictureUrl = "https://www.eatingwell.com/thmb/eygmA1HxG9_zEYRot8grLw16khU=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/EWL-cabbage-caesar-beauty-0057-ab43d6449de64c0a9e2a07f809c711fe.jpg",
            description = "Здесь будет описание",
            likesCount = (0..1000).random(),
            createdAt = Date(2024, (0..4).random(), (0..28).random())
        )
    )

    fun getFoodRecipes(result: (Array<Recipe>) -> Unit) {
        val sorted = mockFoodRecipes.sortedBy {
            it.createdAt
        }

        result(sorted.toTypedArray())
    }

    fun getAllRecipes(result: (Array<Recipe>) -> Unit) {
        getFoodRecipes(result)
    }

    fun getById(id: Int, result: (Recipe) -> Unit) {
        result(mockFoodRecipes.first { it.id == id })
    }
}

class IdGenerator {
    private var counter = 0

    fun next(): Int {
        counter++
        return counter
    }
}