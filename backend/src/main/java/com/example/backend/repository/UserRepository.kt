package com.example.backend.repository

import com.example.backend.data.UserModel

class UserRepository {

    private var list = mutableListOf(
        UserModel(
            0,
            "True Detective",
            "Matthew ",
            "Mcconaughey",
            53,
            "https://www.gannett-cdn.com/presto/2019/10/31/USAT/4fb11f4d-fc52-40ed-9f9e-8473eb7f7045-GTY_589527674.JPG?width=592&format=pjpg&auto=webp&quality=70"
        ),
        UserModel(
            0,
            "User_1",
            "FirstName_1 ",
            "mcconaughey",
            53,
            "https://static.dw.com/image/63743885_605.jpg"
        ),
        UserModel(
            0,
            "User_2",
            "Firstname_2 ",
            "Lastname_2",
            53,
            "https://content.time.com/time/daily/2011/1110/seven_billion_landing.jpg"
        ),
        UserModel(
            0,
            "User_0",
            "FirstName_0 ",
            "Lastname_2",
            53,
            "https://media.licdn.com/dms/image/C5612AQFw1LK_ST0ykw/article-cover_image-shrink_600_2000/0/1520107063637?e=2147483647&v=beta&t=rjQwSHfgkPZUPHes5TXYfDRV5pgdpswWpVy_IJqc3pU"
        ),
        UserModel(
            0,
            "User_0",
            "FirstName_0 ",
            "Lastname_2",
            53,
            "https://toptemebi.files.wordpress.com/2015/03/post-29-1357046294.jpg"
        ),
        UserModel(
            0,
            "User_0",
            "FirstName_0 ",
            "Lastname_2",
            53,
            "https://storage.googleapis.com/feedc_v1_largepostimages/MjI4NTEzX3Bvc3RfMTU5ODA5MzIyOA==.jpeg"
        ),
        UserModel(
            0,
            "User_0",
            "FirstName_0 ",
            "Lastname_2",
            53,
            "https://magma.ge/assets/tinyeditor/filemanager/files/images/images/crowd.jpg"
        ),
        UserModel(
            0,
            "User_0",
            "FirstName_0 ",
            "Lastname_2",
            53,
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTM3b4iQxTS7KwLBHlGTrasSxdZeQtWDEIGkQ&usqp=CAU"
        ),
        UserModel(
            0,
            "User_0",
            "FirstName_0 ",
            "Lastname_2",
            53,
            "https://www.verywellhealth.com/thmb/KdpQtevrYHuhrAGxlIEQ_-AmjOY=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/GettyImages-1205715037-a4668cfe1da44dc7822c16bdc0f6e854.jpg"
        )
    )

    fun getUserList(): List<UserModel> {
        return list
    }
}