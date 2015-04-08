// @SOURCE:C:/Users/MiHu/projects/is-klost/is-klost/conf/routes
// @HASH:ea6b3fba3a994eec3362864731091dace84d53cc
// @DATE:Wed Apr 08 17:32:50 CEST 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:56
// @LINE:55
package com.feth.play.module.pa.controllers {

// @LINE:56
// @LINE:55
class ReverseAuthenticate {


// @LINE:55
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:56
def authenticate(provider:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + implicitly[PathBindable[String]].unbind("provider", dynamicString(provider)))
}
                        

}
                          
}
                  

// @LINE:65
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:57
// @LINE:54
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:34
// @LINE:33
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:3
// @LINE:2
// @LINE:1
package controllers {

// @LINE:62
class ReverseAssets {


// @LINE:62
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:65
// @LINE:63
// @LINE:61
// @LINE:57
// @LINE:54
// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApp {


// @LINE:65
// @LINE:1
def calendar(date:String): Call = {
   (date: @unchecked) match {
// @LINE:1
case (date) if date == "TODAY" =>
  implicit val _rrc = new ReverseRouteContext(Map(("date", "TODAY")))
  Call("GET", _prefix)
                                         
// @LINE:65
case (date)  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("date", dynamicString(date)))
                                         
   }
}
                                                

// @LINE:57
def oAuthDenied(provider:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + implicitly[PathBindable[String]].unbind("provider", dynamicString(provider)) + "/denied")
}
                        

// @LINE:61
def jsRoutes(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/routes")
}
                        

// @LINE:63
def jsMessages(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "jsmessages")
}
                        

// @LINE:3
// @LINE:2
def store(date:String): Call = {
   (date: @unchecked) match {
// @LINE:2
case (date) if date == "TOMMOROW" =>
  implicit val _rrc = new ReverseRouteContext(Map(("date", "TOMMOROW")))
  Call("GET", _prefix + { _defaultPrefix } + "store")
                                         
// @LINE:3
case (date)  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + "store/" + implicitly[PathBindable[String]].unbind("date", dynamicString(date)))
                                         
   }
}
                                                

// @LINE:54
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:34
// @LINE:33
class ReverseAvail {


// @LINE:33
def getEventsAt(date:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/events/" + implicitly[PathBindable[String]].unbind("date", dynamicString(date)))
}
                        

// @LINE:34
def availability(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajax/availability")
}
                        

}
                          

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseEvents {


// @LINE:17
def drag(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:9
def editInstl(id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/INSTALLATION/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:19
def changeCal(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/event/changeCal/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:10
def updateInstl(id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/INSTALLATION/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:12
def editStrmn(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/storeman/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:11
def deleteInstl(id:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "event/INSTALLATION/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:15
def update(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:13
def updateStrmn(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/storeman/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:16
def delete(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:7
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajax/event")
}
                        

// @LINE:14
def edit(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:20
def upcomingActions(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/actions/upcoming")
}
                        

// @LINE:8
def addAndEdit(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "event/addAndEdit")
}
                        

// @LINE:18
def getEntries(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/entries/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

}
                          

// @LINE:51
// @LINE:50
// @LINE:49
class ReverseDocuments {


// @LINE:49
def priceOffer(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "priceOffer/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:51
def loadingList(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "loadingList/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:50
def contract(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "contract/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

}
                          

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseTents {


// @LINE:44
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id) + "/delete")
}
                        

// @LINE:41
def edit(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:43
def update(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:40
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tent")
}
                        

// @LINE:38
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tents")
}
                        

// @LINE:42
def neuFromTemplate(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id) + "/fromTemplate")
}
                        

// @LINE:39
def neu(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tent")
}
                        

// @LINE:45
def getTent(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/tent/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseItems {


// @LINE:29
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "ajax/item/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:26
def listEventItems(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/listEventItems")
}
                        

// @LINE:28
def update(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/item/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:25
def listTentItems(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/listTentItems")
}
                        

// @LINE:27
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajax/item")
}
                        

// @LINE:24
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/items")
}
                        

}
                          
}
                  


// @LINE:56
// @LINE:55
package com.feth.play.module.pa.controllers.javascript {
import ReverseRouteContext.empty

// @LINE:56
// @LINE:55
class ReverseAuthenticate {


// @LINE:55
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.feth.play.module.pa.controllers.Authenticate.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:56
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.feth.play.module.pa.controllers.Authenticate.authenticate",
   """
      function(provider) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("provider", encodeURIComponent(provider))})
      }
   """
)
                        

}
              
}
        

// @LINE:65
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:57
// @LINE:54
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:34
// @LINE:33
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:62
class ReverseAssets {


// @LINE:62
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:65
// @LINE:63
// @LINE:61
// @LINE:57
// @LINE:54
// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApp {


// @LINE:65
// @LINE:1
def calendar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.calendar",
   """
      function(date) {
      if (date == """ + implicitly[JavascriptLitteral[String]].to("TODAY") + """) {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("date", encodeURIComponent(date))})
      }
      }
   """
)
                        

// @LINE:57
def oAuthDenied : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.oAuthDenied",
   """
      function(provider) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("provider", encodeURIComponent(provider)) + "/denied"})
      }
   """
)
                        

// @LINE:61
def jsRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.jsRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/routes"})
      }
   """
)
                        

// @LINE:63
def jsMessages : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.jsMessages",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "jsmessages"})
      }
   """
)
                        

// @LINE:3
// @LINE:2
def store : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.store",
   """
      function(date) {
      if (date == """ + implicitly[JavascriptLitteral[String]].to("TOMMOROW") + """) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("date", encodeURIComponent(date))})
      }
      }
   """
)
                        

// @LINE:54
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:34
// @LINE:33
class ReverseAvail {


// @LINE:33
def getEventsAt : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Avail.getEventsAt",
   """
      function(date) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/events/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("date", encodeURIComponent(date))})
      }
   """
)
                        

// @LINE:34
def availability : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Avail.availability",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/availability"})
      }
   """
)
                        

}
              

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseEvents {


// @LINE:17
def drag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.drag",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:9
def editInstl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.editInstl",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/INSTALLATION/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:19
def changeCal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.changeCal",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/event/changeCal/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:10
def updateInstl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.updateInstl",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/INSTALLATION/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:12
def editStrmn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.editStrmn",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/storeman/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:11
def deleteInstl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.deleteInstl",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "event/INSTALLATION/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:15
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.update",
   """
      function(eventType,id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:13
def updateStrmn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.updateStrmn",
   """
      function(eventType,id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/storeman/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:16
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.delete",
   """
      function(eventType,id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:7
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/event"})
      }
   """
)
                        

// @LINE:14
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.edit",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:20
def upcomingActions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.upcomingActions",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/actions/upcoming"})
      }
   """
)
                        

// @LINE:8
def addAndEdit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.addAndEdit",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "event/addAndEdit"})
      }
   """
)
                        

// @LINE:18
def getEntries : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.getEntries",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/entries/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

}
              

// @LINE:51
// @LINE:50
// @LINE:49
class ReverseDocuments {


// @LINE:49
def priceOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Documents.priceOffer",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "priceOffer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:51
def loadingList : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Documents.loadingList",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "loadingList/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:50
def contract : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Documents.contract",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contract/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

}
              

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseTents {


// @LINE:44
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.delete",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/delete"})
      }
   """
)
                        

// @LINE:41
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:43
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.update",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:40
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tent"})
      }
   """
)
                        

// @LINE:38
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tents"})
      }
   """
)
                        

// @LINE:42
def neuFromTemplate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.neuFromTemplate",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/fromTemplate"})
      }
   """
)
                        

// @LINE:39
def neu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.neu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tent"})
      }
   """
)
                        

// @LINE:45
def getTent : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.getTent",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseItems {


// @LINE:29
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:26
def listEventItems : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.listEventItems",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/listEventItems"})
      }
   """
)
                        

// @LINE:28
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.update",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:25
def listTentItems : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.listTentItems",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/listTentItems"})
      }
   """
)
                        

// @LINE:27
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item"})
      }
   """
)
                        

// @LINE:24
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/items"})
      }
   """
)
                        

}
              
}
        


// @LINE:56
// @LINE:55
package com.feth.play.module.pa.controllers.ref {


// @LINE:56
// @LINE:55
class ReverseAuthenticate {


// @LINE:55
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.feth.play.module.pa.controllers.Authenticate.logout(), HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:56
def authenticate(provider:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.feth.play.module.pa.controllers.Authenticate.authenticate(provider), HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]), "GET", """""", _prefix + """authenticate/$provider<[^/]+>""")
)
                      

}
                          
}
        

// @LINE:65
// @LINE:63
// @LINE:62
// @LINE:61
// @LINE:57
// @LINE:54
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:34
// @LINE:33
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.ref {


// @LINE:62
class ReverseAssets {


// @LINE:62
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:65
// @LINE:63
// @LINE:61
// @LINE:57
// @LINE:54
// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApp {


// @LINE:1
def calendar(date:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.calendar(date), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "calendar", Seq(classOf[String]), "GET", """""", _prefix + """""")
)
                      

// @LINE:57
def oAuthDenied(provider:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.oAuthDenied(provider), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "oAuthDenied", Seq(classOf[String]), "GET", """""", _prefix + """authenticate/$provider<[^/]+>/denied""")
)
                      

// @LINE:61
def jsRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.jsRoutes(), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "jsRoutes", Seq(), "GET", """------------- Public files and JS routes serving
------------------------------------------------""", _prefix + """assets/javascripts/routes""")
)
                      

// @LINE:63
def jsMessages(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.jsMessages(), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "jsMessages", Seq(), "GET", """""", _prefix + """jsmessages""")
)
                      

// @LINE:2
def store(date:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.store(date), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "store", Seq(classOf[String]), "GET", """""", _prefix + """store""")
)
                      

// @LINE:54
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "login", Seq(), "GET", """ Play-authenticate routes""", _prefix + """login""")
)
                      

}
                          

// @LINE:34
// @LINE:33
class ReverseAvail {


// @LINE:33
def getEventsAt(date:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Avail.getEventsAt(date), HandlerDef(this.getClass.getClassLoader, "", "controllers.Avail", "getEventsAt", Seq(classOf[String]), "GET", """------------- AVAILABILITY
--------------------------""", _prefix + """ajax/events/$date<[^/]+>""")
)
                      

// @LINE:34
def availability(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Avail.availability(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Avail", "availability", Seq(), "POST", """""", _prefix + """ajax/availability""")
)
                      

}
                          

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
class ReverseEvents {


// @LINE:17
def drag(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.drag(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "drag", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """ajax/event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:9
def editInstl(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.editInstl(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editInstl", Seq(classOf[String]), "GET", """""", _prefix + """event/INSTALLATION/$id<[^/]+>""")
)
                      

// @LINE:19
def changeCal(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.changeCal(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "changeCal", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """ajax/event/changeCal/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:10
def updateInstl(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.updateInstl(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateInstl", Seq(classOf[String]), "POST", """""", _prefix + """event/INSTALLATION/$id<[^/]+>""")
)
                      

// @LINE:12
def editStrmn(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.editStrmn(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editStrmn", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/storeman/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:11
def deleteInstl(id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.deleteInstl(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "deleteInstl", Seq(classOf[String]), "DELETE", """""", _prefix + """event/INSTALLATION/$id<[^/]+>""")
)
                      

// @LINE:15
def update(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.update(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "update", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:13
def updateStrmn(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.updateStrmn(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateStrmn", Seq(classOf[String], classOf[String]), "POST", """""", _prefix + """event/storeman/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:16
def delete(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.delete(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "delete", Seq(classOf[String], classOf[String]), "DELETE", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:7
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.add(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "add", Seq(), "POST", """------------- EEVENTS
---------------------""", _prefix + """ajax/event""")
)
                      

// @LINE:14
def edit(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.edit(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "edit", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:20
def upcomingActions(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.upcomingActions(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "upcomingActions", Seq(), "GET", """""", _prefix + """ajax/actions/upcoming""")
)
                      

// @LINE:8
def addAndEdit(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.addAndEdit(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "addAndEdit", Seq(), "POST", """""", _prefix + """event/addAndEdit""")
)
                      

// @LINE:18
def getEntries(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.getEntries(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "getEntries", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """ajax/entries/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

}
                          

// @LINE:51
// @LINE:50
// @LINE:49
class ReverseDocuments {


// @LINE:49
def priceOffer(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Documents.priceOffer(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "priceOffer", Seq(classOf[String], classOf[String]), "GET", """------------- DOCUMENTS
-----------------------""", _prefix + """priceOffer/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:51
def loadingList(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Documents.loadingList(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "loadingList", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """loadingList/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:50
def contract(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Documents.contract(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "contract", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """contract/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

}
                          

// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseTents {


// @LINE:44
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]), "POST", """""", _prefix + """tent/$id<[^/]+>/delete""")
)
                      

// @LINE:41
def edit(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.edit(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]), "GET", """""", _prefix + """tent/$id<[^/]+>""")
)
                      

// @LINE:43
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.update(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]), "POST", """""", _prefix + """tent/$id<[^/]+>""")
)
                      

// @LINE:40
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.add(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "add", Seq(), "POST", """""", _prefix + """tent""")
)
                      

// @LINE:38
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Seq(), "GET", """------------- TENTS
-------------------""", _prefix + """tents""")
)
                      

// @LINE:42
def neuFromTemplate(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.neuFromTemplate(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neuFromTemplate", Seq(classOf[Long]), "GET", """""", _prefix + """tent/$id<[^/]+>/fromTemplate""")
)
                      

// @LINE:39
def neu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.neu(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Seq(), "GET", """""", _prefix + """tent""")
)
                      

// @LINE:45
def getTent(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.getTent(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "getTent", Seq(classOf[Long]), "GET", """""", _prefix + """ajax/tent/$id<[^/]+>""")
)
                      

}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
class ReverseItems {


// @LINE:29
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """ajax/item/$id<[^/]+>""")
)
                      

// @LINE:26
def listEventItems(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.listEventItems(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "listEventItems", Seq(), "GET", """""", _prefix + """ajax/listEventItems""")
)
                      

// @LINE:28
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.update(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "update", Seq(classOf[Long]), "PUT", """""", _prefix + """ajax/item/$id<[^/]+>""")
)
                      

// @LINE:25
def listTentItems(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.listTentItems(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "listTentItems", Seq(), "GET", """""", _prefix + """ajax/listTentItems""")
)
                      

// @LINE:27
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.add(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "add", Seq(), "POST", """""", _prefix + """ajax/item""")
)
                      

// @LINE:24
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "list", Seq(), "GET", """------------- ITEMS
-------------------""", _prefix + """ajax/items""")
)
                      

}
                          
}
        
    