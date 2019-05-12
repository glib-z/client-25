package gz;

import gz.api.ApiManager;
import gz.model.Message;
import gz.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {
        tGetAllUsers();
        //tRemoveAllUsers();
        //tGetUserById(45);

        Timestamp timestamp_curr = new Timestamp(System.currentTimeMillis());
        tUpdateUser(new User(16, "Client", timestamp_curr));
    }


    private static void tGetAllUsers() {

        ApiManager.getApiService().getAllUsers().enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tGetAllUsers() -> onResponse: " + message);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tGetAllUsers() -> onFailure: " + throwable);
            }
        });

    }

    private static void tUpdateUser(User user) {

        ApiManager.getApiService().
                updateUser(user).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tUpdateUser(): " + message);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tUpdateUser() -> onFailure: " + throwable);
            }
        });

    }


    //===== ^ CHECKED ^ =====



    private static void tRemoveAllUsers() {

        ApiManager.getApiService().removeAllUsers().enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tRemoveAllUsers(): " + message);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tRemoveAllUsers() -> onFailure: " + throwable);
            }
        });

    }



    private static void tGetUserById(int id) {

        ApiManager.getApiService().getUserById(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tGetUserById(): " + message);
            }

            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tGetUserById() -> onFailure: " + throwable);
            }
        });
    }


}
