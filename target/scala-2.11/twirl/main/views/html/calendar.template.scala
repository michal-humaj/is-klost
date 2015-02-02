
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
object calendar extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main(Messages("nav.cal"))/*1.45*/(0)/*1.48*/ {_display_(Seq[Any](format.raw/*1.50*/("""

    """),_display_(/*3.6*/views/*3.11*/.html.master.datepicker()),format.raw/*3.36*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),format.raw/*5.5*/("""Calendar
""")))}/*6.2*/ {_display_(Seq[Any](format.raw/*6.4*/("""
    """),format.raw/*7.5*/("""<script src='"""),_display_(/*7.19*/routes/*7.25*/.Assets.at("js/calendarAdmin.js")),format.raw/*7.58*/("""'></script>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 11:59:56 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/calendar.scala.html
                  HASH: d4f9e73e3a790b1c272de461ecc9ac1d0813f76d
                  MATRIX: 801->1|813->6|859->44|870->47|909->49|941->56|954->61|999->86|1018->88|1056->90|1087->95|1114->105|1152->107|1183->112|1223->126|1237->132|1290->165
                  LINES: 29->1|29->1|29->1|29->1|29->1|31->3|31->3|31->3|32->4|32->4|33->5|34->6|34->6|35->7|35->7|35->7|35->7
                  -- GENERATED --
              */
          