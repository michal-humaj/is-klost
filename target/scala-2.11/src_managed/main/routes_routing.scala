// @SOURCE:C:/Users/MiHu/Documents/projects/is-klost/is-klost/conf/routes
// @HASH:8f4d11c44bcc0dd7ec15b2d19ac4da82942428a6
// @DATE:Fri Mar 13 08:35:17 CET 2015


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
        

// @LINE:7
private[this] lazy val controllers_Events_add3_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/event"))))
private[this] lazy val controllers_Events_add3_invoker = createInvoker(
controllers.Events.add(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "add", Nil,"POST", """------------- EEVENTS
---------------------""", Routes.prefix + """ajax/event"""))
        

// @LINE:8
private[this] lazy val controllers_Events_addAndEdit4_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/addAndEdit"))))
private[this] lazy val controllers_Events_addAndEdit4_invoker = createInvoker(
controllers.Events.addAndEdit(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "addAndEdit", Nil,"POST", """""", Routes.prefix + """event/addAndEdit"""))
        

// @LINE:9
private[this] lazy val controllers_Events_editInstl5_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/INSTALLATION/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_editInstl5_invoker = createInvoker(
controllers.Events.editInstl(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editInstl", Seq(classOf[String]),"GET", """""", Routes.prefix + """event/INSTALLATION/$id<[^/]+>"""))
        

// @LINE:10
private[this] lazy val controllers_Events_updateInstl6_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/INSTALLATION/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_updateInstl6_invoker = createInvoker(
controllers.Events.updateInstl(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateInstl", Seq(classOf[String]),"POST", """""", Routes.prefix + """event/INSTALLATION/$id<[^/]+>"""))
        

// @LINE:11
private[this] lazy val controllers_Events_deleteInstl7_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/INSTALLATION/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_deleteInstl7_invoker = createInvoker(
controllers.Events.deleteInstl(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "deleteInstl", Seq(classOf[String]),"DELETE", """""", Routes.prefix + """event/INSTALLATION/$id<[^/]+>"""))
        

// @LINE:12
private[this] lazy val controllers_Events_editStrmn8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/storeman/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_editStrmn8_invoker = createInvoker(
controllers.Events.editStrmn(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editStrmn", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/storeman/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:13
private[this] lazy val controllers_Events_updateStrmn9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/storeman/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_updateStrmn9_invoker = createInvoker(
controllers.Events.updateStrmn(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateStrmn", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/storeman/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:14
private[this] lazy val controllers_Events_edit10_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_edit10_invoker = createInvoker(
controllers.Events.edit(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "edit", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:15
private[this] lazy val controllers_Events_update11_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_update11_invoker = createInvoker(
controllers.Events.update(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "update", Seq(classOf[String], classOf[String]),"POST", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:16
private[this] lazy val controllers_Events_delete12_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_delete12_invoker = createInvoker(
controllers.Events.delete(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "delete", Seq(classOf[String], classOf[String]),"DELETE", """""", Routes.prefix + """event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:17
private[this] lazy val controllers_Events_drag13_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/event/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_drag13_invoker = createInvoker(
controllers.Events.drag(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "drag", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """ajax/event/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:18
private[this] lazy val controllers_Events_getEntries14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/entries/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_getEntries14_invoker = createInvoker(
controllers.Events.getEntries(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "getEntries", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """ajax/entries/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_Events_changeCal15_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/event/changeCal/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Events_changeCal15_invoker = createInvoker(
controllers.Events.changeCal(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "changeCal", Seq(classOf[String], classOf[String]),"PUT", """""", Routes.prefix + """ajax/event/changeCal/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:20
private[this] lazy val controllers_Events_upcomingActions16_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/actions/upcoming"))))
private[this] lazy val controllers_Events_upcomingActions16_invoker = createInvoker(
controllers.Events.upcomingActions(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "upcomingActions", Nil,"GET", """""", Routes.prefix + """ajax/actions/upcoming"""))
        

// @LINE:24
private[this] lazy val controllers_Items_list17_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/items"))))
private[this] lazy val controllers_Items_list17_invoker = createInvoker(
controllers.Items.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "list", Nil,"GET", """------------- ITEMS
-------------------""", Routes.prefix + """ajax/items"""))
        

// @LINE:25
private[this] lazy val controllers_Items_listTentItems18_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/listTentItems"))))
private[this] lazy val controllers_Items_listTentItems18_invoker = createInvoker(
controllers.Items.listTentItems(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "listTentItems", Nil,"GET", """""", Routes.prefix + """ajax/listTentItems"""))
        

// @LINE:26
private[this] lazy val controllers_Items_listEventItems19_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/listEventItems"))))
private[this] lazy val controllers_Items_listEventItems19_invoker = createInvoker(
controllers.Items.listEventItems(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "listEventItems", Nil,"GET", """""", Routes.prefix + """ajax/listEventItems"""))
        

// @LINE:27
private[this] lazy val controllers_Items_add20_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item"))))
private[this] lazy val controllers_Items_add20_invoker = createInvoker(
controllers.Items.add(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "add", Nil,"POST", """""", Routes.prefix + """ajax/item"""))
        

// @LINE:28
private[this] lazy val controllers_Items_update21_route = Route("PUT", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Items_update21_invoker = createInvoker(
controllers.Items.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "update", Seq(classOf[Long]),"PUT", """""", Routes.prefix + """ajax/item/$id<[^/]+>"""))
        

// @LINE:29
private[this] lazy val controllers_Items_delete22_route = Route("DELETE", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/item/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Items_delete22_invoker = createInvoker(
controllers.Items.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "delete", Seq(classOf[Long]),"DELETE", """""", Routes.prefix + """ajax/item/$id<[^/]+>"""))
        

// @LINE:33
private[this] lazy val controllers_Avail_getEventsAt23_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/events/"),DynamicPart("date", """[^/]+""",true))))
private[this] lazy val controllers_Avail_getEventsAt23_invoker = createInvoker(
controllers.Avail.getEventsAt(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Avail", "getEventsAt", Seq(classOf[String]),"GET", """------------- AVAILABILITY
--------------------------""", Routes.prefix + """ajax/events/$date<[^/]+>"""))
        

// @LINE:34
private[this] lazy val controllers_Avail_availability24_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/availability"))))
private[this] lazy val controllers_Avail_availability24_invoker = createInvoker(
controllers.Avail.availability(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Avail", "availability", Nil,"POST", """""", Routes.prefix + """ajax/availability"""))
        

// @LINE:38
private[this] lazy val controllers_Tents_list25_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tents"))))
private[this] lazy val controllers_Tents_list25_invoker = createInvoker(
controllers.Tents.list(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Nil,"GET", """------------- TENTS
-------------------""", Routes.prefix + """tents"""))
        

// @LINE:39
private[this] lazy val controllers_Tents_neu26_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent"))))
private[this] lazy val controllers_Tents_neu26_invoker = createInvoker(
controllers.Tents.neu(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Nil,"GET", """""", Routes.prefix + """tent"""))
        

// @LINE:40
private[this] lazy val controllers_Tents_add27_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent"))))
private[this] lazy val controllers_Tents_add27_invoker = createInvoker(
controllers.Tents.add(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "add", Nil,"POST", """""", Routes.prefix + """tent"""))
        

// @LINE:41
private[this] lazy val controllers_Tents_edit28_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_edit28_invoker = createInvoker(
controllers.Tents.edit(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]),"GET", """""", Routes.prefix + """tent/$id<[^/]+>"""))
        

// @LINE:42
private[this] lazy val controllers_Tents_update29_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_update29_invoker = createInvoker(
controllers.Tents.update(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tent/$id<[^/]+>"""))
        

// @LINE:43
private[this] lazy val controllers_Tents_delete30_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("tent/"),DynamicPart("id", """[^/]+""",true),StaticPart("/delete"))))
private[this] lazy val controllers_Tents_delete30_invoker = createInvoker(
controllers.Tents.delete(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]),"POST", """""", Routes.prefix + """tent/$id<[^/]+>/delete"""))
        

// @LINE:44
private[this] lazy val controllers_Tents_getTent31_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajax/tent/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Tents_getTent31_invoker = createInvoker(
controllers.Tents.getTent(fakeValue[Long]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "getTent", Seq(classOf[Long]),"GET", """""", Routes.prefix + """ajax/tent/$id<[^/]+>"""))
        

// @LINE:48
private[this] lazy val controllers_Documents_priceOffer32_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("priceOffer/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Documents_priceOffer32_invoker = createInvoker(
controllers.Documents.priceOffer(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "priceOffer", Seq(classOf[String], classOf[String]),"GET", """------------- DOCUMENTS
-----------------------""", Routes.prefix + """priceOffer/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:49
private[this] lazy val controllers_Documents_contract33_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("contract/"),DynamicPart("eventType", """[^/]+""",true),StaticPart("/"),DynamicPart("id", """[^/]+""",true))))
private[this] lazy val controllers_Documents_contract33_invoker = createInvoker(
controllers.Documents.contract(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "contract", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """contract/$eventType<[^/]+>/$id<[^/]+>"""))
        

// @LINE:52
private[this] lazy val controllers_App_login34_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("login"))))
private[this] lazy val controllers_App_login34_invoker = createInvoker(
controllers.App.login(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "login", Nil,"GET", """ Play-authenticate routes""", Routes.prefix + """login"""))
        

// @LINE:53
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout35_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("logout"))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_logout35_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.logout,
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Nil,"GET", """""", Routes.prefix + """logout"""))
        

// @LINE:54
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate36_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true))))
private[this] lazy val com_feth_play_module_pa_controllers_Authenticate_authenticate36_invoker = createInvoker(
com.feth.play.module.pa.controllers.Authenticate.authenticate(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>"""))
        

// @LINE:55
private[this] lazy val controllers_App_oAuthDenied37_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("authenticate/"),DynamicPart("provider", """[^/]+""",true),StaticPart("/denied"))))
private[this] lazy val controllers_App_oAuthDenied37_invoker = createInvoker(
controllers.App.oAuthDenied(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "oAuthDenied", Seq(classOf[String]),"GET", """""", Routes.prefix + """authenticate/$provider<[^/]+>/denied"""))
        

// @LINE:59
private[this] lazy val controllers_App_jsRoutes38_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/javascripts/routes"))))
private[this] lazy val controllers_App_jsRoutes38_invoker = createInvoker(
controllers.App.jsRoutes(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "jsRoutes", Nil,"GET", """------------- Public files and JS routes serving
------------------------------------------------""", Routes.prefix + """assets/javascripts/routes"""))
        

// @LINE:60
private[this] lazy val controllers_Assets_at39_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_at39_invoker = createInvoker(
controllers.Assets.at(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]),"GET", """""", Routes.prefix + """assets/$file<.+>"""))
        

// @LINE:61
private[this] lazy val controllers_App_jsMessages40_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("jsmessages"))))
private[this] lazy val controllers_App_jsMessages40_invoker = createInvoker(
controllers.App.jsMessages(),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "jsMessages", Nil,"GET", """""", Routes.prefix + """jsmessages"""))
        

// @LINE:63
private[this] lazy val controllers_App_calendar41_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("date", """[^/]+""",true))))
private[this] lazy val controllers_App_calendar41_invoker = createInvoker(
controllers.App.calendar(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "calendar", Seq(classOf[String]),"GET", """""", Routes.prefix + """$date<[^/]+>"""))
        
def documentation = List(("""GET""", prefix,"""controllers.App.calendar(date:String = "TODAY")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store""","""controllers.App.store(date:String = "TOMMOROW")"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """store/$date<[^/]+>""","""controllers.App.store(date:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/event""","""controllers.Events.add()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/addAndEdit""","""controllers.Events.addAndEdit()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/INSTALLATION/$id<[^/]+>""","""controllers.Events.editInstl(id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/INSTALLATION/$id<[^/]+>""","""controllers.Events.updateInstl(id:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/INSTALLATION/$id<[^/]+>""","""controllers.Events.deleteInstl(id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/storeman/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.editStrmn(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/storeman/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.updateStrmn(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.edit(eventType:String, id:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.update(eventType:String, id:String)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.delete(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/event/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.drag(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/entries/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.getEntries(eventType:String, id:String)"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/event/changeCal/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Events.changeCal(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/actions/upcoming""","""controllers.Events.upcomingActions()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/items""","""controllers.Items.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/listTentItems""","""controllers.Items.listTentItems()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/listEventItems""","""controllers.Items.listEventItems()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item""","""controllers.Items.add()"""),("""PUT""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item/$id<[^/]+>""","""controllers.Items.update(id:Long)"""),("""DELETE""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/item/$id<[^/]+>""","""controllers.Items.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/events/$date<[^/]+>""","""controllers.Avail.getEventsAt(date:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/availability""","""controllers.Avail.availability()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tents""","""controllers.Tents.list()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent""","""controllers.Tents.neu()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent""","""controllers.Tents.add()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent/$id<[^/]+>""","""controllers.Tents.edit(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent/$id<[^/]+>""","""controllers.Tents.update(id:Long)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """tent/$id<[^/]+>/delete""","""controllers.Tents.delete(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajax/tent/$id<[^/]+>""","""controllers.Tents.getTent(id:Long)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """priceOffer/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Documents.priceOffer(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """contract/$eventType<[^/]+>/$id<[^/]+>""","""controllers.Documents.contract(eventType:String, id:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """login""","""controllers.App.login()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """logout""","""com.feth.play.module.pa.controllers.Authenticate.logout"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>""","""com.feth.play.module.pa.controllers.Authenticate.authenticate(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """authenticate/$provider<[^/]+>/denied""","""controllers.App.oAuthDenied(provider:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/javascripts/routes""","""controllers.App.jsRoutes()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.at(path:String = "/public", file:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """jsmessages""","""controllers.App.jsMessages()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$date<[^/]+>""","""controllers.App.calendar(date:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
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
        

// @LINE:7
case controllers_Events_add3_route(params) => {
   call { 
        controllers_Events_add3_invoker.call(controllers.Events.add())
   }
}
        

// @LINE:8
case controllers_Events_addAndEdit4_route(params) => {
   call { 
        controllers_Events_addAndEdit4_invoker.call(controllers.Events.addAndEdit())
   }
}
        

// @LINE:9
case controllers_Events_editInstl5_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Events_editInstl5_invoker.call(controllers.Events.editInstl(id))
   }
}
        

// @LINE:10
case controllers_Events_updateInstl6_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Events_updateInstl6_invoker.call(controllers.Events.updateInstl(id))
   }
}
        

// @LINE:11
case controllers_Events_deleteInstl7_route(params) => {
   call(params.fromPath[String]("id", None)) { (id) =>
        controllers_Events_deleteInstl7_invoker.call(controllers.Events.deleteInstl(id))
   }
}
        

// @LINE:12
case controllers_Events_editStrmn8_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_editStrmn8_invoker.call(controllers.Events.editStrmn(eventType, id))
   }
}
        

// @LINE:13
case controllers_Events_updateStrmn9_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_updateStrmn9_invoker.call(controllers.Events.updateStrmn(eventType, id))
   }
}
        

// @LINE:14
case controllers_Events_edit10_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_edit10_invoker.call(controllers.Events.edit(eventType, id))
   }
}
        

// @LINE:15
case controllers_Events_update11_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_update11_invoker.call(controllers.Events.update(eventType, id))
   }
}
        

// @LINE:16
case controllers_Events_delete12_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_delete12_invoker.call(controllers.Events.delete(eventType, id))
   }
}
        

// @LINE:17
case controllers_Events_drag13_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_drag13_invoker.call(controllers.Events.drag(eventType, id))
   }
}
        

// @LINE:18
case controllers_Events_getEntries14_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_getEntries14_invoker.call(controllers.Events.getEntries(eventType, id))
   }
}
        

// @LINE:19
case controllers_Events_changeCal15_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Events_changeCal15_invoker.call(controllers.Events.changeCal(eventType, id))
   }
}
        

// @LINE:20
case controllers_Events_upcomingActions16_route(params) => {
   call { 
        controllers_Events_upcomingActions16_invoker.call(controllers.Events.upcomingActions())
   }
}
        

// @LINE:24
case controllers_Items_list17_route(params) => {
   call { 
        controllers_Items_list17_invoker.call(controllers.Items.list())
   }
}
        

// @LINE:25
case controllers_Items_listTentItems18_route(params) => {
   call { 
        controllers_Items_listTentItems18_invoker.call(controllers.Items.listTentItems())
   }
}
        

// @LINE:26
case controllers_Items_listEventItems19_route(params) => {
   call { 
        controllers_Items_listEventItems19_invoker.call(controllers.Items.listEventItems())
   }
}
        

// @LINE:27
case controllers_Items_add20_route(params) => {
   call { 
        controllers_Items_add20_invoker.call(controllers.Items.add())
   }
}
        

// @LINE:28
case controllers_Items_update21_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Items_update21_invoker.call(controllers.Items.update(id))
   }
}
        

// @LINE:29
case controllers_Items_delete22_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Items_delete22_invoker.call(controllers.Items.delete(id))
   }
}
        

// @LINE:33
case controllers_Avail_getEventsAt23_route(params) => {
   call(params.fromPath[String]("date", None)) { (date) =>
        controllers_Avail_getEventsAt23_invoker.call(controllers.Avail.getEventsAt(date))
   }
}
        

// @LINE:34
case controllers_Avail_availability24_route(params) => {
   call { 
        controllers_Avail_availability24_invoker.call(controllers.Avail.availability())
   }
}
        

// @LINE:38
case controllers_Tents_list25_route(params) => {
   call { 
        controllers_Tents_list25_invoker.call(controllers.Tents.list())
   }
}
        

// @LINE:39
case controllers_Tents_neu26_route(params) => {
   call { 
        controllers_Tents_neu26_invoker.call(controllers.Tents.neu())
   }
}
        

// @LINE:40
case controllers_Tents_add27_route(params) => {
   call { 
        controllers_Tents_add27_invoker.call(controllers.Tents.add())
   }
}
        

// @LINE:41
case controllers_Tents_edit28_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_edit28_invoker.call(controllers.Tents.edit(id))
   }
}
        

// @LINE:42
case controllers_Tents_update29_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_update29_invoker.call(controllers.Tents.update(id))
   }
}
        

// @LINE:43
case controllers_Tents_delete30_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_delete30_invoker.call(controllers.Tents.delete(id))
   }
}
        

// @LINE:44
case controllers_Tents_getTent31_route(params) => {
   call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_Tents_getTent31_invoker.call(controllers.Tents.getTent(id))
   }
}
        

// @LINE:48
case controllers_Documents_priceOffer32_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Documents_priceOffer32_invoker.call(controllers.Documents.priceOffer(eventType, id))
   }
}
        

// @LINE:49
case controllers_Documents_contract33_route(params) => {
   call(params.fromPath[String]("eventType", None), params.fromPath[String]("id", None)) { (eventType, id) =>
        controllers_Documents_contract33_invoker.call(controllers.Documents.contract(eventType, id))
   }
}
        

// @LINE:52
case controllers_App_login34_route(params) => {
   call { 
        controllers_App_login34_invoker.call(controllers.App.login())
   }
}
        

// @LINE:53
case com_feth_play_module_pa_controllers_Authenticate_logout35_route(params) => {
   call { 
        com_feth_play_module_pa_controllers_Authenticate_logout35_invoker.call(com.feth.play.module.pa.controllers.Authenticate.logout)
   }
}
        

// @LINE:54
case com_feth_play_module_pa_controllers_Authenticate_authenticate36_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        com_feth_play_module_pa_controllers_Authenticate_authenticate36_invoker.call(com.feth.play.module.pa.controllers.Authenticate.authenticate(provider))
   }
}
        

// @LINE:55
case controllers_App_oAuthDenied37_route(params) => {
   call(params.fromPath[String]("provider", None)) { (provider) =>
        controllers_App_oAuthDenied37_invoker.call(controllers.App.oAuthDenied(provider))
   }
}
        

// @LINE:59
case controllers_App_jsRoutes38_route(params) => {
   call { 
        controllers_App_jsRoutes38_invoker.call(controllers.App.jsRoutes())
   }
}
        

// @LINE:60
case controllers_Assets_at39_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at39_invoker.call(controllers.Assets.at(path, file))
   }
}
        

// @LINE:61
case controllers_App_jsMessages40_route(params) => {
   call { 
        controllers_App_jsMessages40_invoker.call(controllers.App.jsMessages())
   }
}
        

// @LINE:63
case controllers_App_calendar41_route(params) => {
   call(params.fromPath[String]("date", None)) { (date) =>
        controllers_App_calendar41_invoker.call(controllers.App.calendar(date))
   }
}
        
}

}
     