package gz;

import gz.api.ApiManager;
import gz.model.Message;
import gz.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        Timestamp timestamp_curr = new Timestamp(System.currentTimeMillis());
        tAddUser(new User(-1, "AddedByClient", timestamp_curr));
        tUpdateUser(new User(16, "Client", timestamp_curr));
        tGetAllUsers();
        tGetUserById(14);
        tGetUserByName("Second");
        tRemoveUser(18);
        tRemoveAllUsers();
        Calendar calendarFrom = new GregorianCalendar(2010, 0, 1);
        Calendar calendarTo = new GregorianCalendar(2018, 5, 23);
        tGetAllUsersByDateBirth(calendarFrom.getTimeInMillis(), calendarTo.getTimeInMillis());
    }


    private static void tAddUser(User user) {
        ApiManager.getApiService().addUser(user).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tAddUser(): " + message);
            }
            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tAddUser() -> onFailure: " + throwable);
            }
        });
    }


    private static void tUpdateUser(User user) {
        ApiManager.getApiService().updateUser(user).enqueue(new Callback<Message>() {
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


    private static void tGetUserByName(String name) {
        ApiManager.getApiService().getUserByName(name).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tGetUserByName(): " + message);
            }
            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tGetUserByName() -> onFailure: " + throwable);
            }
        });
    }


    private static void tRemoveUser(int id) {
        ApiManager.getApiService().removeUser(id).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tRemoveUser(): " + message);
            }
            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tRemoveUser() -> onFailure: " + throwable);
            }
        });
    }


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

    //===== ^ CHECKED ^ =====

    private static void tGetAllUsersByDateBirth(Long tsFrom, Long tsTo) {
        ApiManager.getApiService().getAllUsersByDateBirth(tsFrom, tsTo).enqueue(new Callback<Message>() {
            @Override
            public void onResponse(Call<Message> call, Response<Message> response) {
                Message message = response.body();
                System.out.println("tGetAllUsersByDateBirth(): " + message);
            }
            @Override
            public void onFailure(Call<Message> call, Throwable throwable) {
                System.out.println("tGetAllUsersByDateBirth() -> onFailure: " + throwable);
            }
        });
    }

}
