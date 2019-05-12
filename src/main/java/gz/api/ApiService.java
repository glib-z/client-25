package gz.api;

import gz.model.Message;
import gz.model.User;
import retrofit2.Call;
import retrofit2.http.*;

public interface ApiService {

    @POST("api/add_user/{name}/{birth}")
    Call<Message> addUser(@Body User user);

    @POST("api/update_user")
    Call<Message> updateUser(@Body User user);

    @DELETE("api/remove_user/{id}")
    Call<Message> removeUser(@Path("id") int id);

    @DELETE("api/remove_users")
    Call<Message> removeAllUsers();

    @GET("api/get_all_users")
    Call<Message> getAllUsers();

    @GET("get_user_by_id/{id}")
    Call<Message> getUserById(@Path("id") int id);

    @GET("get_user_by_id/{name}")
    Call<Message> getUserByName(@Path("name") String name);

}
