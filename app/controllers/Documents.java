package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;

/**
 * Created by MiHu on 11.1.2015.
 */
@Security.Authenticated(LoggedStoremanOrAdmin.class)
public class Documents extends Controller {
 public static Result priceOffer(String eventType, String id) {
  return play.mvc.Results.TODO;
 }

 public static Result contract(String eventType, String id) {
  return play.mvc.Results.TODO;
 }
}
