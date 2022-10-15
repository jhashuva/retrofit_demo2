package edu.cvr.retrofitdemo2

import retrofit2.Call
import retrofit2.http.*


interface RetroService {

    //https://gorest.co.in/public-api/users
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUsersList(): Call<UserList>

    //https://gorest.co.in/public-api/users?name=a
    @GET("users")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun searchUsers(@Query("name") searchText:String): Call<UserList>

    //https://gorest.co.in/public-api/users?name=a
    @GET("users{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json")
    fun getUser(@Path("user_id") user_id:String): Call<UserList>


    //https://gorest.co.in/public-api/users/121
    //curl -i -H "Accept:application/json" -H "Content-Type:application/json" -H "Authorization: Bearer ACCESS-TOKEN" -XPOST "https://gorest.co.in/public/v2/users" -d '{"name":"Tenali Ramakrishna", "gender":"male", "email":"tenali.ramakrishna@15ce.com", "status":"active"}'
    @POST("users")
    @Headers("Accept:application/json","Content-Type:application/json",
    "Authorization: Bearer 2ec10d30a3117989198048eb9f074c4f68b16b99d841a055d8ef05ff860e602c")
    fun createUser(@Body params: User):Call<UserResponse>


    @PATCH("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer 2ec10d30a3117989198048eb9f074c4f68b16b99d841a055d8ef05ff860e602c")
    fun updateUser(@Path("user_id") user_id:String,@Body params: User):Call<UserResponse>


    @DELETE("users/{user_id}")
    @Headers("Accept:application/json","Content-Type:application/json",
        "Authorization: Bearer 2ec10d30a3117989198048eb9f074c4f68b16b99d841a055d8ef05ff860e602c")
    fun deleteUser(@Path("user_id") user_id:String):Call<UserResponse>


}