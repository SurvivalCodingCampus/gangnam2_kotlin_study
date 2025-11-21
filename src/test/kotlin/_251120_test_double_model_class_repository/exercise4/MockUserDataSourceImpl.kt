package _251120_test_double_model_class_repository.exercise4

class MockUserDataSourceImpl : UserDataSource {

    val mockUserList = listOf(
        User(
            id = 2,
            name = "name2",
            email = "email2",
            address = Address(
                city = "city2",
                geo = Geo(lat = "lat2", lng = "lng2"),
                street = "street2",
                suite = "suite2",
                zipcode = "zipcode2"
            ),
            phone = "phone2",
            website = "website2",
            company = Company(bs = "bs2", catchPhrase = "catchPhrase2", name = "name2"),
            username = "username2"
        ),
        User(
            id = 1,
            name = "name1",
            email = "email1",
            address = Address(
                city = "city1",
                geo = Geo(lat = "lat1", lng = "lng1"),
                street = "street1",
                suite = "suite1",
                zipcode = "zipcode1"
            ),
            phone = "phone1",
            website = "website1",
            company = Company(bs = "bs1", catchPhrase = "catchPhrase1", name = "name1"),
            username = "username1"
        ),
    )

    override suspend fun getAllUser(): List<User> {
        return mockUserList
    }

}