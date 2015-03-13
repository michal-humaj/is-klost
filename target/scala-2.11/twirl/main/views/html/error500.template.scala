
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
object error500 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main("500")/*1.31*/(3)/*1.34*/ {_display_(Seq[Any](format.raw/*1.36*/("""
""")))}/*2.2*/ {_display_(Seq[Any](format.raw/*2.4*/("""
    """),format.raw/*3.5*/("""<div class="row">
        <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!-- #section:pages/error -->
            <div class="error-container">
                <div class="well">
                    <h1 class="grey lighter smaller">
                        <span class="blue bigger-125">
                            <i class="ace-icon fa fa-random"></i>
                            500
                        </span>
                        """),_display_(/*14.26*/Messages("err.500.h")),format.raw/*14.47*/("""
                    """),format.raw/*15.21*/("""</h1>
                    <hr />
                    <h3 class="lighter smaller">
                        <i class="ace-icon fa fa-wrench icon-animated-wrench bigger-125"></i>
                        """),_display_(/*19.26*/Messages("err.500.p")),format.raw/*19.47*/("""
                    """),format.raw/*20.21*/("""</h3>

                    <hr />
                    <div class="space"></div>
                    <div class="center">
                        <a href="javascript:history.back()" class="btn btn-grey">
                            <i class="ace-icon fa fa-arrow-left"></i>
                            """),_display_(/*27.30*/Messages("btn.back")),format.raw/*27.50*/("""
                        """),format.raw/*28.25*/("""</a>
                        <a href='"""),_display_(/*29.35*/routes/*29.41*/.App.calendar("TODAY")),format.raw/*29.63*/("""' class="btn btn-primary">
                            <i class="ace-icon fa fa-calendar-o"></i>
                            """),_display_(/*31.30*/Messages("nav.cal")),format.raw/*31.49*/("""
                        """),format.raw/*32.25*/("""</a>
                    </div>
                </div>
            </div>
                <!-- /section:pages/error -->
                <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div> <!-- /.row -->
""")))}/*40.2*/ {_display_(Seq[Any](format.raw/*40.4*/("""
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Fri Mar 13 20:24:30 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/error500.scala.html
                  HASH: 0020d26458c83c87bbfb717a4cc244ee7cad8e70
                  MATRIX: 801->1|813->6|845->30|856->33|895->35|914->37|952->39|983->44|1492->526|1534->547|1583->568|1811->769|1853->790|1902->811|2231->1113|2272->1133|2325->1158|2391->1197|2406->1203|2449->1225|2602->1351|2642->1370|2695->1395|2932->1614|2971->1616
                  LINES: 29->1|29->1|29->1|29->1|29->1|30->2|30->2|31->3|42->14|42->14|43->15|47->19|47->19|48->20|55->27|55->27|56->28|57->29|57->29|57->29|59->31|59->31|60->32|68->40|68->40
                  -- GENERATED --
              */
          