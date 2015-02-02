// @SOURCE:C:/Users/MiHu/Documents/projects/is-klost/is-klost/conf/routes
// @HASH:64d23bc35a91baa9e4fd5de102df9d6d8f861c8a
// @DATE:Mon Feb 02 11:06:53 CET 2015

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset
import _root_.play.libs.F

import Router.queryString


// @LINE:10
// @LINE:9
package com.feth.play.module.pa.controllers {

// @LINE:10
// @LINE:9
class ReverseAuthenticate {


// @LINE:9
def logout(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                        

// @LINE:10
def authenticate(provider:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + implicitly[PathBindable[String]].unbind("provider", dynamicString(provider)))
}
                        

}
                          
}
                  

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:56
// @LINE:55
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:42
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:11
// @LINE:8
// @LINE:5
// @LINE:3
// @LINE:2
// @LINE:1
package controllers {

// @LINE:61
class ReverseAssets {


// @LINE:61
def at(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:62
// @LINE:60
// @LINE:11
// @LINE:8
// @LINE:5
// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApp {


// @LINE:62
// @LINE:1
def calendar(date:String): Call = {
   (date: @unchecked) match {
// @LINE:1
case (date) if date == "TODAY" =>
  implicit val _rrc = new ReverseRouteContext(Map(("date", "TODAY")))
  Call("GET", _prefix)
                                         
// @LINE:62
case (date)  =>
  import ReverseRouteContext.empty
  Call("GET", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("date", dynamicString(date)))
                                         
   }
}
                                                

// @LINE:5
def storeStrmn(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "store/storeman")
}
                        

// @LINE:11
def oAuthDenied(provider:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "authenticate/" + implicitly[PathBindable[String]].unbind("provider", dynamicString(provider)) + "/denied")
}
                        

// @LINE:60
def jsRoutes(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "assets/javascripts/routes")
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
                                                

// @LINE:8
def login(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                        

}
                          

// @LINE:42
class ReverseAvail {


// @LINE:42
def availability(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/avail")
}
                        

}
                          

// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:16
class ReverseEvents {


// @LINE:24
def drag(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/event/drag" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("eventType", eventType)), Some(implicitly[QueryStringBindable[String]].unbind("id", id)))))
}
                        

// @LINE:25
def changeCal(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/changeCal")
}
                        

// @LINE:22
def editInstl(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/INSTALLATION/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("eventType", eventType)))))
}
                        

// @LINE:20
def editStrmn(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/storeman")
}
                        

// @LINE:18
def update(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:23
def updateInstl(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "event/INSTALLATION/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("eventType", eventType)))))
}
                        

// @LINE:21
def updateStrmn(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)) + "/storeman")
}
                        

// @LINE:26
def delete(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:16
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajax/event")
}
                        

// @LINE:17
def edit(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "event/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:28
def upcomingActions(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/actions/upcoming")
}
                        

}
                          

// @LINE:56
// @LINE:55
class ReverseDocuments {


// @LINE:55
def priceOffer(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "priceOffer/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

// @LINE:56
def contract(eventType:String, id:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "contract/" + implicitly[PathBindable[String]].unbind("eventType", dynamicString(eventType)) + "/" + implicitly[PathBindable[String]].unbind("id", dynamicString(id)))
}
                        

}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
class ReverseTents {


// @LINE:51
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:49
def edit(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:50
def update(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "tent/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:48
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "tent")
}
                        

// @LINE:46
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tents")
}
                        

// @LINE:47
def neu(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "tent")
}
                        

}
                          

// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
class ReverseItems {


// @LINE:36
def delete(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("DELETE", _prefix + { _defaultPrefix } + "ajax/item/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:38
def export(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/export")
}
                        

// @LINE:37
def imprt(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/item/" + implicitly[PathBindable[Long]].unbind("id", id) + "/import")
}
                        

// @LINE:35
def update(id:Long): Call = {
   import ReverseRouteContext.empty
   Call("PUT", _prefix + { _defaultPrefix } + "ajax/item/" + implicitly[PathBindable[Long]].unbind("id", id))
}
                        

// @LINE:34
def add(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajax/item")
}
                        

// @LINE:33
def list(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajax/items")
}
                        

}
                          
}
                  


// @LINE:10
// @LINE:9
package com.feth.play.module.pa.controllers.javascript {
import ReverseRouteContext.empty

// @LINE:10
// @LINE:9
class ReverseAuthenticate {


// @LINE:9
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "com.feth.play.module.pa.controllers.Authenticate.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:10
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
        

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:56
// @LINE:55
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:42
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:11
// @LINE:8
// @LINE:5
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:61
class ReverseAssets {


// @LINE:61
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:62
// @LINE:60
// @LINE:11
// @LINE:8
// @LINE:5
// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApp {


// @LINE:62
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
                        

// @LINE:5
def storeStrmn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.storeStrmn",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "store/storeman"})
      }
   """
)
                        

// @LINE:11
def oAuthDenied : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.oAuthDenied",
   """
      function(provider) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "authenticate/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("provider", encodeURIComponent(provider)) + "/denied"})
      }
   """
)
                        

// @LINE:60
def jsRoutes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.jsRoutes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/javascripts/routes"})
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
                        

// @LINE:8
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.App.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

}
              

// @LINE:42
class ReverseAvail {


// @LINE:42
def availability : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Avail.availability",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/avail"})
      }
   """
)
                        

}
              

// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:16
class ReverseEvents {


// @LINE:24
def drag : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.drag",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/event/drag" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("eventType", eventType), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:25
def changeCal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.changeCal",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/changeCal"})
      }
   """
)
                        

// @LINE:22
def editInstl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.editInstl",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/INSTALLATION/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("eventType", eventType)])})
      }
   """
)
                        

// @LINE:20
def editStrmn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.editStrmn",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/storeman"})
      }
   """
)
                        

// @LINE:18
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.update",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:23
def updateInstl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.updateInstl",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "event/INSTALLATION/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("eventType", eventType)])})
      }
   """
)
                        

// @LINE:21
def updateStrmn : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.updateStrmn",
   """
      function(eventType,id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id)) + "/storeman"})
      }
   """
)
                        

// @LINE:26
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.delete",
   """
      function(eventType,id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:16
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/event"})
      }
   """
)
                        

// @LINE:17
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.edit",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "event/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:28
def upcomingActions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Events.upcomingActions",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/actions/upcoming"})
      }
   """
)
                        

}
              

// @LINE:56
// @LINE:55
class ReverseDocuments {


// @LINE:55
def priceOffer : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Documents.priceOffer",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "priceOffer/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

// @LINE:56
def contract : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Documents.contract",
   """
      function(eventType,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "contract/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("eventType", encodeURIComponent(eventType)) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("id", encodeURIComponent(id))})
      }
   """
)
                        

}
              

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
class ReverseTents {


// @LINE:51
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:49
def edit : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.edit",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:50
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.update",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "tent/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:48
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tent"})
      }
   """
)
                        

// @LINE:46
def list : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.list",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tents"})
      }
   """
)
                        

// @LINE:47
def neu : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Tents.neu",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "tent"})
      }
   """
)
                        

}
              

// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
class ReverseItems {


// @LINE:36
def delete : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.delete",
   """
      function(id) {
      return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:38
def export : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.export",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/export"})
      }
   """
)
                        

// @LINE:37
def imprt : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.imprt",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id) + "/import"})
      }
   """
)
                        

// @LINE:35
def update : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.update",
   """
      function(id) {
      return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("id", id)})
      }
   """
)
                        

// @LINE:34
def add : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Items.add",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajax/item"})
      }
   """
)
                        

// @LINE:33
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
        


// @LINE:10
// @LINE:9
package com.feth.play.module.pa.controllers.ref {


// @LINE:10
// @LINE:9
class ReverseAuthenticate {


// @LINE:9
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.feth.play.module.pa.controllers.Authenticate.logout(), HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:10
def authenticate(provider:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   com.feth.play.module.pa.controllers.Authenticate.authenticate(provider), HandlerDef(this.getClass.getClassLoader, "", "com.feth.play.module.pa.controllers.Authenticate", "authenticate", Seq(classOf[String]), "GET", """""", _prefix + """authenticate/$provider<[^/]+>""")
)
                      

}
                          
}
        

// @LINE:62
// @LINE:61
// @LINE:60
// @LINE:56
// @LINE:55
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:42
// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:11
// @LINE:8
// @LINE:5
// @LINE:3
// @LINE:2
// @LINE:1
package controllers.ref {


// @LINE:61
class ReverseAssets {


// @LINE:61
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:62
// @LINE:60
// @LINE:11
// @LINE:8
// @LINE:5
// @LINE:3
// @LINE:2
// @LINE:1
class ReverseApp {


// @LINE:1
def calendar(date:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.calendar(date), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "calendar", Seq(classOf[String]), "GET", """""", _prefix + """""")
)
                      

// @LINE:5
def storeStrmn(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.storeStrmn(), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "storeStrmn", Seq(), "GET", """  pre skladnika zobrazit sklad""", _prefix + """store/storeman""")
)
                      

// @LINE:11
def oAuthDenied(provider:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.oAuthDenied(provider), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "oAuthDenied", Seq(classOf[String]), "GET", """""", _prefix + """authenticate/$provider<[^/]+>/denied""")
)
                      

// @LINE:60
def jsRoutes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.jsRoutes(), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "jsRoutes", Seq(), "GET", """------------- Public files and JS routes serving
------------------------------------------------""", _prefix + """assets/javascripts/routes""")
)
                      

// @LINE:2
def store(date:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.store(date), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "store", Seq(classOf[String]), "GET", """""", _prefix + """store""")
)
                      

// @LINE:8
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.App.login(), HandlerDef(this.getClass.getClassLoader, "", "controllers.App", "login", Seq(), "GET", """ Play-authenticate routes""", _prefix + """login""")
)
                      

}
                          

// @LINE:42
class ReverseAvail {


// @LINE:42
def availability(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Avail.availability(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Avail", "availability", Seq(), "GET", """------------- AVAILABILITY
--------------------------""", _prefix + """ajax/avail""")
)
                      

}
                          

// @LINE:28
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:21
// @LINE:20
// @LINE:18
// @LINE:17
// @LINE:16
class ReverseEvents {


// @LINE:24
def drag(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.drag(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "drag", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """ajax/event/drag""")
)
                      

// @LINE:25
def changeCal(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.changeCal(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "changeCal", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """ajax/event/$eventType<[^/]+>/$id<[^/]+>/changeCal""")
)
                      

// @LINE:22
def editInstl(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.editInstl(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editInstl", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/INSTALLATION/$id<[^/]+>""")
)
                      

// @LINE:20
def editStrmn(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.editStrmn(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "editStrmn", Seq(classOf[String], classOf[String]), "GET", """skladnik edit a update""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>/storeman""")
)
                      

// @LINE:18
def update(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.update(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "update", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:23
def updateInstl(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.updateInstl(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateInstl", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """event/INSTALLATION/$id<[^/]+>""")
)
                      

// @LINE:21
def updateStrmn(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.updateStrmn(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "updateStrmn", Seq(classOf[String], classOf[String]), "PUT", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>/storeman""")
)
                      

// @LINE:26
def delete(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.delete(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "delete", Seq(classOf[String], classOf[String]), "DELETE", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:16
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.add(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "add", Seq(), "POST", """------------- EEVENTS
---------------------""", _prefix + """ajax/event""")
)
                      

// @LINE:17
def edit(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.edit(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "edit", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """event/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:28
def upcomingActions(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Events.upcomingActions(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Events", "upcomingActions", Seq(), "GET", """""", _prefix + """ajax/actions/upcoming""")
)
                      

}
                          

// @LINE:56
// @LINE:55
class ReverseDocuments {


// @LINE:55
def priceOffer(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Documents.priceOffer(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "priceOffer", Seq(classOf[String], classOf[String]), "GET", """------------- DOCUMENTS
-----------------------""", _prefix + """priceOffer/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

// @LINE:56
def contract(eventType:String, id:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Documents.contract(eventType, id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Documents", "contract", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """contract/$eventType<[^/]+>/$id<[^/]+>""")
)
                      

}
                          

// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
class ReverseTents {


// @LINE:51
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """tent/$id<[^/]+>""")
)
                      

// @LINE:49
def edit(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.edit(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "edit", Seq(classOf[Long]), "GET", """""", _prefix + """tent/$id<[^/]+>""")
)
                      

// @LINE:50
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.update(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "update", Seq(classOf[Long]), "PUT", """""", _prefix + """tent/$id<[^/]+>""")
)
                      

// @LINE:48
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.add(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "add", Seq(), "POST", """""", _prefix + """tent""")
)
                      

// @LINE:46
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "list", Seq(), "GET", """------------- TENTS
-------------------""", _prefix + """tents""")
)
                      

// @LINE:47
def neu(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Tents.neu(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Tents", "neu", Seq(), "GET", """""", _prefix + """tent""")
)
                      

}
                          

// @LINE:38
// @LINE:37
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
class ReverseItems {


// @LINE:36
def delete(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.delete(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "delete", Seq(classOf[Long]), "DELETE", """""", _prefix + """ajax/item/$id<[^/]+>""")
)
                      

// @LINE:38
def export(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.export(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "export", Seq(classOf[Long]), "PUT", """""", _prefix + """ajax/item/$id<[^/]+>/export""")
)
                      

// @LINE:37
def imprt(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.imprt(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "imprt", Seq(classOf[Long]), "PUT", """""", _prefix + """ajax/item/$id<[^/]+>/import""")
)
                      

// @LINE:35
def update(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.update(id), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "update", Seq(classOf[Long]), "PUT", """""", _prefix + """ajax/item/$id<[^/]+>""")
)
                      

// @LINE:34
def add(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.add(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "add", Seq(), "POST", """""", _prefix + """ajax/item""")
)
                      

// @LINE:33
def list(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Items.list(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Items", "list", Seq(), "GET", """------------- ITEMS
-------------------""", _prefix + """ajax/items""")
)
                      

}
                          
}
        
    