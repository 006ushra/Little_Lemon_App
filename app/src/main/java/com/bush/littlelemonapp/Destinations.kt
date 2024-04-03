package com.bush.littlelemonapp

interface Destinations {
    val route: String
}

object Home: Destinations {
    override val route = "Home"
}

object DishDetails: Destinations {
    override val route = "details"
    val argDishId = "dishId"
}