package com.survivalcoding.kotlinstudy.`15_repository`.practice.users.data_source

import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.Address
import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.Company
import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.Geo
import com.survivalcoding.kotlinstudy.`15_repository`.practice.users.model.User

class MockUserDataSourceImpl : UserDataSource {
    override suspend fun getUsersFileData(): List<User> {
        return listOf(
            User(
                id = 1,
                name = "Mike",
                username = "mike01",
                email = "mike@example.com",
                address = Address(
                    street = "1st Street",
                    suite = "Apt. 101",
                    city = "Seoul",
                    zipcode = "00001",
                    geo = Geo(
                        lat = "37.5665",
                        lng = "126.9780"
                    )
                ),
                phone = "010-0000-0001",
                website = "mike.dev",
                company = Company(
                    name = "Mike Corp",
                    catchPhrase = "Code everyday",
                    bs = "software"
                )
            ),
            User(
                id = 2,
                name = "Anna",
                username = "anna01",
                email = "anna@example.com",
                address = Address(
                    street = "2nd Street",
                    suite = "Apt. 202",
                    city = "Busan",
                    zipcode = "00002",
                    geo = Geo(
                        lat = "35.1796",
                        lng = "129.0756"
                    )
                ),
                phone = "010-0000-0002",
                website = "anna.io",
                company = Company(
                    name = "Anna Studio",
                    catchPhrase = "Design first",
                    bs = "design"
                )
            ),
            User(
                id = 3,
                name = "Chris",
                username = "chris01",
                email = "chris@example.com",
                address = Address(
                    street = "3rd Street",
                    suite = "Suite 303",
                    city = "Incheon",
                    zipcode = "00003",
                    geo = Geo(
                        lat = "37.4563",
                        lng = "126.7052"
                    )
                ),
                phone = "010-0000-0003",
                website = "chris.me",
                company = Company(
                    name = "Chris Labs",
                    catchPhrase = "Move fast",
                    bs = "research"
                )
            ),
            User(
                id = 4,
                name = "Bella",
                username = "bella01",
                email = "bella@example.com",
                address = Address(
                    street = "4th Street",
                    suite = "Apt. 404",
                    city = "Daegu",
                    zipcode = "00004",
                    geo = Geo(
                        lat = "35.8714",
                        lng = "128.6014"
                    )
                ),
                phone = "010-0000-0004",
                website = "bella.dev",
                company = Company(
                    name = "Bella Works",
                    catchPhrase = "Keep shining",
                    bs = "media"
                )
            ),
            User(
                id = 5,
                name = "David",
                username = "david01",
                email = "david@example.com",
                address = Address(
                    street = "5th Street",
                    suite = "Suite 505",
                    city = "Daejeon",
                    zipcode = "00005",
                    geo = Geo(
                        lat = "36.3504",
                        lng = "127.3845"
                    )
                ),
                phone = "010-0000-0005",
                website = "david.net",
                company = Company(
                    name = "David Co",
                    catchPhrase = "Be reliable",
                    bs = "infra"
                )
            ),
            User(
                id = 6,
                name = "Emma",
                username = "emma01",
                email = "emma@example.com",
                address = Address(
                    street = "6th Street",
                    suite = "Apt. 606",
                    city = "Ulsan",
                    zipcode = "00006",
                    geo = Geo(
                        lat = "35.5384",
                        lng = "129.3114"
                    )
                ),
                phone = "010-0000-0006",
                website = "emma.app",
                company = Company(
                    name = "Emma Tech",
                    catchPhrase = "Simple and clean",
                    bs = "mobile"
                )
            ),
            User(
                id = 7,
                name = "Frank",
                username = "frank01",
                email = "frank@example.com",
                address = Address(
                    street = "7th Street",
                    suite = "Suite 707",
                    city = "Gwangju",
                    zipcode = "00007",
                    geo = Geo(
                        lat = "35.1595",
                        lng = "126.8526"
                    )
                ),
                phone = "010-0000-0007",
                website = "frank.dev",
                company = Company(
                    name = "Frank Global",
                    catchPhrase = "Go worldwide",
                    bs = "logistics"
                )
            ),
            User(
                id = 8,
                name = "Grace",
                username = "grace01",
                email = "grace@example.com",
                address = Address(
                    street = "8th Street",
                    suite = "Apt. 808",
                    city = "Suwon",
                    zipcode = "00008",
                    geo = Geo(
                        lat = "37.2636",
                        lng = "127.0286"
                    )
                ),
                phone = "010-0000-0008",
                website = "grace.design",
                company = Company(
                    name = "Grace Studio",
                    catchPhrase = "Make it beautiful",
                    bs = "branding"
                )
            ),
            User(
                id = 9,
                name = "Henry",
                username = "henry01",
                email = "henry@example.com",
                address = Address(
                    street = "9th Street",
                    suite = "Suite 909",
                    city = "Jeju",
                    zipcode = "00009",
                    geo = Geo(
                        lat = "33.4996",
                        lng = "126.5312"
                    )
                ),
                phone = "010-0000-0009",
                website = "henry.kr",
                company = Company(
                    name = "Henry Island",
                    catchPhrase = "Relax and code",
                    bs = "tourism"
                )
            ),
            User(
                id = 10,
                name = "Ivy",
                username = "ivy01",
                email = "ivy@example.com",
                address = Address(
                    street = "10th Street",
                    suite = "Apt. 1001",
                    city = "Sejong",
                    zipcode = "00010",
                    geo = Geo(
                        lat = "36.4800",
                        lng = "127.2890"
                    )
                ),
                phone = "010-0000-0010",
                website = "ivy.io",
                company = Company(
                    name = "Ivy Co",
                    catchPhrase = "Grow fast",
                    bs = "startup"
                )
            ),
            User(
                id = 11,
                name = "Jack",
                username = "jack01",
                email = "jack@example.com",
                address = Address(
                    street = "11th Street",
                    suite = "Suite 1102",
                    city = "Pohang",
                    zipcode = "00011",
                    geo = Geo(
                        lat = "36.0190",
                        lng = "129.3435"
                    )
                ),
                phone = "010-0000-0011",
                website = "jack.dev",
                company = Company(
                    name = "Jack Steel",
                    catchPhrase = "Strong and solid",
                    bs = "manufacturing"
                )
            ),
            User(
                id = 12,
                name = "Kelly",
                username = "kelly01",
                email = "kelly@example.com",
                address = Address(
                    street = "12th Street",
                    suite = "Apt. 1203",
                    city = "Changwon",
                    zipcode = "00012",
                    geo = Geo(
                        lat = "35.2280",
                        lng = "128.6811"
                    )
                ),
                phone = "010-0000-0012",
                website = "kelly.space",
                company = Company(
                    name = "Kelly Space",
                    catchPhrase = "Reach higher",
                    bs = "aerospace"
                )
            )
        )
    }
}
