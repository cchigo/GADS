package me.chigo.gads.utils.service;

import java.util.List;

import io.reactivex.Observable;
import me.chigo.gads.model.hours.HoursResponseData;
import me.chigo.gads.utils.UrlConstants;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface NetworkService {
    @GET(UrlConstants.LEARNING_LEADERS)
    Observable<List<HoursResponseData>> getLeadersHours();

    @POST(UrlConstants.SUBMIT)
    @FormUrlEncoded
    Observable<Object> submit(@Field("entry.1877115667") String firstName, @Field("entry.2006916086") String lastName, @Field("entry.1824927963") String emailAdd, @Field("entry.284483984") String githubLink);

}
