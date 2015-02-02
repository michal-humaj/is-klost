// @SOURCE:C:/Users/MiHu/Documents/projects/is-klost/is-klost/conf/routes
// @HASH:64d23bc35a91baa9e4fd5de102df9d6d8f861c8a
// @DATE:Mon Feb 02 11:30:57 CET 2015


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:1
private[this] lazy val controllers_App_calendar0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
private[this] lazy val controllers_App_calendar0_invoker = createInvoker(
controllers.App.calendar(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "calendar", Seq(classOf[String]),"GET", """""", Routes.prefix + """"""))
        

// @LINE:2
private[this] lazy val controllers_App_store1_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store"))))
private[this] lazy val controllers_App_store1_invoker = createInvoker(
controllers.App.store(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "store", Seq(classOf[String]),"GET", """""", Routes.prefix + """store"""))
        

// @LINE:3
private[this] lazy val controllers_App_store2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/"),DynamicPart("date", """[^/]+""",true))))
private[this] lazy val controllers_App_store2_invoker = createInvoker(
controllers.App.store(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "store", Seq(classOf[String]),"GET", """""", Routes.prefix + """store/$date<[^/]+>"""))
        

// @LINE:5
private[this] lazy val controllers_App_storeStrmn3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("store/storeman"))))
private[this] lazy val controllers_App_storeStrmn3_invoker = createInvoker(
controllers.App.storeStrmn(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "storeStrmn", Nil,"GET", """  pre skladnika zobrazit sklad""", Routes.prefix + """store/storeman"""))
        

// @LINE:8
private[this] lazy val controllers_App_login4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_App_login4_invoker = createInvoker(
controllers.App.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "login", Nil,"GET", """ Play-authenticate routes""", Routes.prefix + """login"""))
        

// @LINE:9
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout5_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.logout,
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:10
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate6_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.authenticate(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>"""))
        

// @LINE:11
private[this] lazy val controllers_App_oAuthDenied7_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true),StaticPart("/denied"))))
private[this] lazy val controllers_App_oAuthDenied7_invoker = createInvoker(
controllers.App.oAuthDenied(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "oAuthDenied", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>/denied"""))
        

// @LINE:16
private[this] lazy val controllers_Events_add8_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/event"))))
private[this] lazy val controllers_Events_add8_invoker = createInvoker(
controllers.Events.add(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "add", Nil,"POST", """------------- EEVENTS
---------------------""", Routes.prefix + """ajax/event"""))
        

// @LINE:17
private[this] lazy val controllers_Events_edit9_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_edit9_invoker = createInvoker(
controllers.Events.edit(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "edit", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:18
private[this] lazy val controllers_Events_update10_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_update10_invoker = createInvoker(
controllers.Events.update(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "update", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_Events_editStrmn11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true),StaticPart("/storeman"))))
private[this] lazy val controllers_Events_editStrmn11_invoker = createInvoker(
controllers.Events.editStrmn(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editStrmn", Seq(classOf[String], classOf[String]),"GET", """skladnik edit a update""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>/storeman"""))
        

// @LINE:21
private[this] lazy val controllers_Events_updateStrmn12_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true),StaticPart("/storeman"))))
private[this] lazy val controllers_Events_updateStrmn12_invoker = createInvoker(
controllers.Events.updateStrmn(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateStrmn", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>/storeman"""))
        

// @LINE:22
private[this] lazy val controllers_Events_editInstl13_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/INSTALLATION/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_editInstl13_invoker = createInvoker(
controllers.Events.editInstl(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editInstl", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/INSTALLATION/$id<[^/]+>"""))
        

// @LINE:23
private[this] lazy val controllers_Events_updateInstl14_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/INSTALLATION/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_updateInstl14_invoker = createInvoker(
controllers.Events.updateInstl(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateInstl", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """event/INSTALLATION/$id<[^/]+>"""))
        

// @LINE:24
private[this] lazy val controllers_Events_drag15_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/event/drag"))))
private[this] lazy val controllers_Events_drag15_invoker = createInvoker(
controllers.Events.drag(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "drag", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """ajax/event/drag"""))
        

// @LINE:25
private[this] lazy val controllers_Events_changeCal16_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true),StaticPart("/changeCal"))))
private[this] lazy val controllers_Events_changeCal16_invoker = createInvoker(
controllers.Events.changeCal(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "changeCal", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """ajax/event/$eventType<[^/]+>/$id<[^/]+>/changeCal"""))
        

// @LINE:26
private[this] lazy val controllers_Events_delete17_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_delete17_invoker = createInvoker(
controllers.Events.delete(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "delete", Seq(classOf[String], classOf[String]),"DELETE", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:28
private[this] lazy val controllers_Events_upcomingActions18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/actions/upcoming"))))
private[this] lazy val controllers_Events_upcomingActions18_invoker = createInvoker(
controllers.Events.upcomingActions(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "upcomingActions", Nil,"GET", """""", Routes.prefix + """ajax/actions/upcoming"""))
        

// @LINE:33
private[this] lazy val controllers_Items_list19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/items"))))
private[this] lazy val controllers_Items_list19_invoker = createInvoker(
controllers.Items.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "list", Nil,"GET", """------------- ITEMS
-------------------""", Routes.prefix + """ajax/items"""))
        

// @LINE:34
private[this] lazy val controllers_Items_add20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item"))))
private[this] lazy val controllers_Items_add20_invoker = createInvoker(
controllers.Items.add(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "add", Nil,"POST", """""", Routes.prefix + """ajax/item"""))
        

// @LINE:35
private[this] lazy val controllers_Items_update21_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Items_update21_invoker = createInvoker(
controllers.Items.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "update", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """ajax/item/$id<[^/]+>"""))
        

// @LINE:36
private[this] lazy val controllers_Items_delete22_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Items_delete22_invoker = createInvoker(
controllers.Items.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """ajax/item/$id<[^/]+>"""))
        

// @LINE:37
private[this] lazy val controllers_Items_imprt23_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/import"))))
private[this] lazy val controllers_Items_imprt23_invoker = createInvoker(
controllers.Items.imprt(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "imprt", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """ajax/item/$id<[^/]+>/import"""))
        

// @LINE:38
private[this] lazy val controllers_Items_export24_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item/"),DynamicPart("id", """[^/]+""",true),StaticPart("/export"))))
private[this] lazy val controllers_Items_export24_invoker = createInvoker(
controllers.Items.export(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "export", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """ajax/item/$id<[^/]+>/export"""))
        

// @LINE:42
private[this] lazy val controllers_Avail_availability25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/avail"))))
private[this] lazy val controllers_Avail_availability25_invoker = createInvoker(
controllers.Avail.availability(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Avail", "availability", Nil,"GET", """------------- AVAILABILITY
--------------------------""", Routes.prefix + """ajax/avail"""))
        

// @LINE:46
private[this] lazy val controllers_Tents_list26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents"))))
private[this] lazy val controllers_Tents_list26_invoker = createInvoker(
controllers.Tents.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Nil,"GET", """------------- TENTS
-------------------""", Routes.prefix + """tents"""))
        

// @LINE:47
private[this] lazy val controllers_Tents_neu27_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent"))))
private[this] lazy val controllers_Tents_neu27_invoker = createInvoker(
controllers.Tents.neu(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Nil,"GET", """""", Routes.prefix + """tent"""))
        

// @LINE:48
private[this] lazy val controllers_Tents_add28_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent"))))
private[this] lazy val controllers_Tents_add28_invoker = createInvoker(
controllers.Tents.add(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "add", Nil,"POST", """""", Routes.prefix + """tent"""))
        

// @LINE:49
private[this] lazy val controllers_Tents_edit29_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_edit29_invoker = createInvoker(
controllers.Tents.edit(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tent/$id<[^/]+>"""))
        

// @LINE:50
private[this] lazy val controllers_Tents_update30_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_update30_invoker = createInvoker(
controllers.Tents.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """tent/$id<[^/]+>"""))
        

// @LINE:51
private[this] lazy val controllers_Tents_delete31_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_delete31_invoker = createInvoker(
controllers.Tents.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """tent/$id<[^/]+>"""))
        

// @LINE:55
private[this] lazy val controllers_Documents_priceOffer32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("priceOffer/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Documents_priceOffer32_invoker = createInvoker(
controllers.Documents.priceOffer(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "priceOffer", Seq(classOf[String], classOf[String]),"GET", """------------- DOCUMENTS
-----------------------""", Routes.prefix + """priceOffer/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:56
private[this] lazy val controllers_Documents_contract33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("contract/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Documents_contract33_invoker = createInvoker(
controllers.Documents.contract(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "contract", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """contract/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:60
private[this] lazy val controllers_App_jsRoutes34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
private[this] lazy val controllers_App_jsRoutes34_invoker = createInvoker(
controllers.App.jsRoutes(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "jsRoutes", Nil,"GET", """------------- Public files and JS routes serving
------------------------------------------------""", Routes.prefix + """assets/javascripts/routes"""))
        

// @LINE:61
private[this] lazy val controllers_Assets_at35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at35_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:62
private[this] lazy val controllers_App_calendar36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("date", """[^/]+""",true))))
private[this] lazy val controllers_App_calendar36_invoker = createInvoker(
controllers.App.calendar(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "calendar", Seq(classOf[String]),"GET", """""", Routes.prefix + """$date<[^/]+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.App.calendar(date:String = "TODAY")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store""","""controllers.App.store(date:String = "TOMMOROW")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/$date<[^/]+>""","""controllers.App.store(date:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/storeman""","""controllers.App.storeStrmn()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.App.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""com.feth.play.module.pa.controllers.Authenticate.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>""","""com.feth.play.module.pa.controllers.Authenticate.authenticate(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>/denied""","""controllers.App.oAuthDenied(provider:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/event""","""controllers.Events.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.edit(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.update(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>/storeman""","""controllers.Events.editStrmn(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>/storeman""","""controllers.Events.updateStrmn(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/INSTALLATION/$id<[^/]+>""","""controllers.Events.editInstl(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/INSTALLATION/$id<[^/]+>""","""controllers.Events.updateInstl(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/event/drag""","""controllers.Events.drag(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/event/$eventType<[^/]+>/$id<[^/]+>/changeCal""","""controllers.Events.changeCal(eventType:String, id:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.delete(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/actions/upcoming""","""controllers.Events.upcomingActions()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/items""","""controllers.Items.list()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item""","""controllers.Items.add()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item/$id<[^/]+>""","""controllers.Items.update(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item/$id<[^/]+>""","""controllers.Items.delete(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item/$id<[^/]+>/import""","""controllers.Items.imprt(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item/$id<[^/]+>/export""","""controllers.Items.export(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/avail""","""controllers.Avail.availability()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents""","""controllers.Tents.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent""","""controllers.Tents.neu()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent""","""controllers.Tents.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent/$id<[^/]+>""","""controllers.Tents.edit(id:Long)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent/$id<[^/]+>""","""controllers.Tents.update(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent/$id<[^/]+>""","""controllers.Tents.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """priceOffer/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Documents.priceOffer(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contract/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Documents.contract(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.App.jsRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$date<[^/]+>""","""controllers.App.calendar(date:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:1
case controllers_App_calendar0_route(params) => {
   call(Param[String]("date", Right("TODAY"))) { (date) =>
        controllers_App_calendar0_invoker.call(controllers.App.calendar(date))
   }
}
        

// @LINE:2
case controllers_App_store1_route(params) => {
   call(Param[String]("date", Right("TOMMOROW"))) { (date) =>
        controllers_App_store1_invoker.call(controllers.App.store(date))
   }
}
        

// @LINE:3
case controllers_App_store2_route(params) => {
   call(params.fromPath[String]("date", None)) { (date) =>
        controllers_App_store2_invoker.call(controllers.App.store(date))
   }
}
        

// @LINE:5
case controllers_App_storeStrmn3_route(params) => {
   call { 
        controllers_App_storeStrmn3_invoker.call(controllers.App.storeStrmn())
   }
}
        

// @LINE:8
case controllers_App_login4_route(params) => {
   call { 
        controllers_App_login4_invoker.call(controllers.App.login())
   }
}
        

// @LINE:9
case com_feth_play_module_pa_controllers_Authenticate_logout5_route(params) => {
   call { 
        com_feth_play_module_pa_controllers_Authenticate_logout5_invoker.call(com.feth.play.module.pa.controllers.Authenticate.logout)
   }
}
        

// @LINE:10
case com_feth_play_module_pa_controllers_Authenticate_authenticate6_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        com_feth_play_module_pa_controllers_Authenticate_authenticate6_invoker.call(com.feth.play.module.pa.controllers.Authenticate.authenticate(provider))
   }
}
        

// @LINE:11
case controllers_App_oAuthDenied7_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_App_oAuthDenied7_invoker.call(controllers.App.oAuthDenied(provider))
   }
}
        

// @LINE:16
case controllers_Events_add8_route(params) => {
   call { 
        controllers_Events_add8_invoker.call(controllers.Events.add())
   }
}
        

// @LINE:17
case controllers_Events_edit9_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_edit9_invoker.call(controllers.Events.edit(eventType, id))
   }
}
        

// @LINE:18
case controllers_Events_update10_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_update10_invoker.call(controllers.Events.update(eventType, id))
   }
}
        

// @LINE:20
case controllers_Events_editStrmn11_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_editStrmn11_invoker.call(controllers.Events.editStrmn(eventType, id))
   }
}
        

// @LINE:21
case controllers_Events_updateStrmn12_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_updateStrmn12_invoker.call(controllers.Events.updateStrmn(eventType, id))
   }
}
        

// @LINE:22
case controllers_Events_editInstl13_route(params) => {
   call(params.fromQuery[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_editInstl13_invoker.call(controllers.Events.editInstl(eventType, id))
   }
}
        

// @LINE:23
case controllers_Events_updateInstl14_route(params) => {
   call(params.fromQuery[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_updateInstl14_invoker.call(controllers.Events.updateInstl(eventType, id))
   }
}
        

// @LINE:24
case controllers_Events_drag15_route(params) => {
   call(params.fromQuery[String]("eventType", None), params.fromQuery[String]("id", None)) { (eventType, id) =>
        controllers_Events_drag15_invoker.call(controllers.Events.drag(eventType, id))
   }
}
        

// @LINE:25
case controllers_Events_changeCal16_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_changeCal16_invoker.call(controllers.Events.changeCal(eventType, id))
   }
}
        

// @LINE:26
case controllers_Events_delete17_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_delete17_invoker.call(controllers.Events.delete(eventType, id))
   }
}
        

// @LINE:28
case controllers_Events_upcomingActions18_route(params) => {
   call { 
        controllers_Events_upcomingActions18_invoker.call(controllers.Events.upcomingActions())
   }
}
        

// @LINE:33
case controllers_Items_list19_route(params) => {
   call { 
        controllers_Items_list19_invoker.call(controllers.Items.list())
   }
}
        

// @LINE:34
case controllers_Items_add20_route(params) => {
   call { 
        controllers_Items_add20_invoker.call(controllers.Items.add())
   }
}
        

// @LINE:35
case controllers_Items_update21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Items_update21_invoker.call(controllers.Items.update(id))
   }
}
        

// @LINE:36
case controllers_Items_delete22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Items_delete22_invoker.call(controllers.Items.delete(id))
   }
}
        

// @LINE:37
case controllers_Items_imprt23_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Items_imprt23_invoker.call(controllers.Items.imprt(id))
   }
}
        

// @LINE:38
case controllers_Items_export24_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Items_export24_invoker.call(controllers.Items.export(id))
   }
}
        

// @LINE:42
case controllers_Avail_availability25_route(params) => {
   call { 
        controllers_Avail_availability25_invoker.call(controllers.Avail.availability())
   }
}
        

// @LINE:46
case controllers_Tents_list26_route(params) => {
   call { 
        controllers_Tents_list26_invoker.call(controllers.Tents.list())
   }
}
        

// @LINE:47
case controllers_Tents_neu27_route(params) => {
   call { 
        controllers_Tents_neu27_invoker.call(controllers.Tents.neu())
   }
}
        

// @LINE:48
case controllers_Tents_add28_route(params) => {
   call { 
        controllers_Tents_add28_invoker.call(controllers.Tents.add())
   }
}
        

// @LINE:49
case controllers_Tents_edit29_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_edit29_invoker.call(controllers.Tents.edit(id))
   }
}
        

// @LINE:50
case controllers_Tents_update30_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_update30_invoker.call(controllers.Tents.update(id))
   }
}
        

// @LINE:51
case controllers_Tents_delete31_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_delete31_invoker.call(controllers.Tents.delete(id))
   }
}
        

// @LINE:55
case controllers_Documents_priceOffer32_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Documents_priceOffer32_invoker.call(controllers.Documents.priceOffer(eventType, id))
   }
}
        

// @LINE:56
case controllers_Documents_contract33_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Documents_contract33_invoker.call(controllers.Documents.contract(eventType, id))
   }
}
        

// @LINE:60
case controllers_App_jsRoutes34_route(params) => {
   call { 
        controllers_App_jsRoutes34_invoker.call(controllers.App.jsRoutes())
   }
}
        

// @LINE:61
case controllers_Assets_at35_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at35_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:62
case controllers_App_calendar36_route(params) => {
   call(params.fromPath[String]("date", None)) { (date) =>
        controllers_App_calendar36_invoker.call(controllers.App.calendar(date))
   }
}
        
}

}
     