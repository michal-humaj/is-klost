
package views.html

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
object store extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main(Messages("nav.store"))/*1.47*/(1)/*1.50*/ {_display_(Seq[Any](format.raw/*1.52*/("""

    """),_display_(/*3.6*/views/*3.11*/.html.master.datepicker()),format.raw/*3.36*/("""
    """),_display_(/*4.6*/views/*4.11*/.html.master.categories()),format.raw/*4.36*/("""
""")))}/*5.2*/ {_display_(Seq[Any](format.raw/*5.4*/("""
    """),format.raw/*6.5*/("""Store
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""
    """),format.raw/*8.5*/("""<script src='"""),_display_(/*8.19*/routes/*8.25*/.Assets.at("js/storeAdmin.js")),format.raw/*8.55*/("""'></script>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 11:42:41 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/store.scala.html
                  HASH: f6bba173acdc05ccce2124db819990246cdb9fa2
                  MATRIX: 798->1|810->6|858->46|869->49|908->51|940->58|953->63|998->88|1029->94|1042->99|1087->124|1106->126|1144->128|1175->133|1199->140|1237->142|1268->147|1308->161|1322->167|1372->197
                  LINES: 29->1|29->1|29->1|29->1|29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|33->5|34->6|35->7|35->7|36->8|36->8|36->8|36->8
                  -- GENERATED --
              */
          