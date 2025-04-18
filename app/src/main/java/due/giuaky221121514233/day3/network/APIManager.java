package due.giuaky221121514233.day3.network;

import due.giuaky221121514233.day3.model.Item;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface APIManager {
    String SERVER_URL = "https://imdb236.p.rapidapi.com/";

    @GET("/imdb/top250-movies")
    Call<List<Item>> getItemData();

    @GET("/imdb/top250-movies")
    Call<List<Item>> getListData();
}

