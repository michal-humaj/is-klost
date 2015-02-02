
package views.html.master

import play.twirl.api._
import play.twirl.api.TemplateMagic._

import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._

/**/
object main extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template5[String,Int,Html,Html,Html,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(title: String)(tabNumber: Int)(sidebar: Html)(content: Html)(javascripts: Html):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.82*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.imports(title)/*3.34*/("no-skin")/*3.45*/ {_display_(Seq[Any](format.raw/*3.47*/("""

    """),_display_(/*5.6*/views/*5.11*/.html.master.navbar(tabNumber)),format.raw/*5.41*/("""

    """),format.raw/*7.5*/("""<div class="main-container" id="main-container" data-target="#sidebar">

        <div id="sidebar" class="sidebar sidebar-fixed responsive">
        """),_display_(/*10.10*/sidebar),format.raw/*10.17*/("""
        """),format.raw/*11.9*/("""</div>

        <div class="main-content">
            <div class="page-content">
            """),_display_(/*15.14*/content),format.raw/*15.21*/("""
            """),format.raw/*16.13*/("""</div>
        </div>

    </div>

""")))}/*21.2*/ {_display_(Seq[Any](format.raw/*21.4*/("""
    """),_display_(/*22.6*/javascripts),format.raw/*22.17*/("""
""")))}))}
  }

  def render(title:String,tabNumber:Int,sidebar:Html,content:Html,javascripts:Html): play.twirl.api.HtmlFormat.Appendable = apply(title)(tabNumber)(sidebar)(content)(javascripts)

  def f:((String) => (Int) => (Html) => (Html) => (Html) => play.twirl.api.HtmlFormat.Appendable) = (title) => (tabNumber) => (sidebar) => (content) => (javascripts) => apply(title)(tabNumber)(sidebar)(content)(javascripts)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 11:47:33 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/main.scala.html
                  HASH: 3fe1314eb1a5483fe53efee081e3ede86a019767
                  MATRIX: 748->1|916->81|944->84|956->89|991->116|1010->127|1049->129|1081->136|1094->141|1144->171|1176->177|1353->327|1381->334|1417->343|1539->438|1567->445|1608->458|1662->494|1701->496|1733->502|1765->513
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|33->5|33->5|33->5|35->7|38->10|38->10|39->11|43->15|43->15|44->16|49->21|49->21|50->22|50->22
                  -- GENERATED --
              */
          