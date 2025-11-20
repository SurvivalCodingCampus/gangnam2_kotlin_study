package com.survivalcoding.kotlinstudy.`15_model_class_repository`.data_source

import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Address
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Company
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.Geo
import com.survivalcoding.kotlinstudy.`15_model_class_repository`.model.User

class MockUserDataSourceImpl : UserDataSource {

    private val mockUsers = listOf(
        User(
            id = 1,
            name = "Leanne Graham",
            username = "Bret",
            email = "Sincere@april.biz",
            address = Address(
                street = "Kulas Light",
                suite = "Apt. 556",
                city = "Gwenborough",
                zipcode = "92998-3874",
                geo = Geo(
                    lat = "-37.3159",
                    lng = "81.1496"
                )
            ),
            phone = "1-770-736-8031 x56442",
            website = "hildegard.org",
            company = Company(
                name = "Romaguera-Crona",
                catchPhrase = "Multi-layered client-server neural-net",
                bs = "harness real-time e-markets"
            )
        ),
        User(
            id = 2,
            name = "Ervin Howell",
            username = "Antonette",
            email = "Shanna@melissa.tv",
            address = Address(
                street = "Victor Plains",
                suite = "Suite 879",
                city = "Wisokyburgh",
                zipcode = "90566-7771",
                geo = Geo(
                    lat = "-43.9509",
                    lng = "-34.4618"
                )
            ),
            phone = "010-692-6593 x09125",
            website = "anastasia.net",
            company = Company(
                name = "Deckow-Crist",
                catchPhrase = "Proactive didactic contingency",
                bs = "synergize scalable supply-chains"
            )
        ),
        User(
            id = 3,
            name = "Clementine Bauch",
            username = "Samantha",
            email = "Nathan@yesenia.net",
            address = Address(
                street = "Douglas Extension",
                suite = "Suite 847",
                city = "McKenziehaven",
                zipcode = "59590-4157",
                geo = Geo(
                    lat = "-68.6102",
                    lng = "-47.0653"
                )
            ),
            phone = "1-463-123-4447",
            website = "ramiro.info",
            company = Company(
                name = "Romaguera-Jacobson",
                catchPhrase = "Face to face bifurcated interface",
                bs = "e-enable strategic applications"
            )
        )
    )

    override suspend fun getUsers(): List<User> = mockUsers
}
