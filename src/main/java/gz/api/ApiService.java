package gz.api;

import gz.model.Message;
import gz.model.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @POST("api/add_user/")
    Call<Message> addUser(@Body User user);

    @POST("api/update_user")
    Call<Message> updateUser(@Body User user);

    @DELETE("api/remove_user/{id}")
    Call<Message> removeUser(@Path("id") int id);

    @DELETE("api/remove_all_users")
    Call<Message> removeAllUsers();

    @GET("api/get_all_users")
    Call<Message> getAllUsers();

    @GET("api/get_user_by_id/{id}")
    Call<Message> getUserById(@Path("id") int id);

    @GET("api/get_user_by_name/{name}")
    Call<Message> getUserByName(@Path("name") String name);

    @GET("get_all_users_by_date_birth/{birth_from}/{birth_to}")
    Call<Message> getAllUsersByDateBirth(@Path("birth_from") Long sTimeFrom, @Path("birth_to") Long sTimeTo);

}
