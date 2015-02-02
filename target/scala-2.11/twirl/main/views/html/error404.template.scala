
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
object error404 extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main("404")/*1.31*/(3)/*1.34*/ {_display_(Seq[Any](format.raw/*1.36*/("""
""")))}/*2.2*/ {_display_(Seq[Any](format.raw/*2.4*/("""
    """),format.raw/*3.5*/("""<div class="row">
        <div class="col-xs-12">
                <!-- PAGE CONTENT BEGINS -->
                <!-- #section:pages/error -->
            <div class="error-container">
                <div class="well">
                    <h1 class="grey lighter smaller">
                        <span class="blue bigger-125">
                            <i class="ace-icon fa fa-sitemap"></i>
                            404
                        </span>
                        Page Not Found
                    </h1>
                    <hr />
                    <h3 class="lighter smaller">"""),_display_(/*17.50*/Messages("err.404")),format.raw/*17.69*/("""</h3>
                    <hr />
                    <div class="space"></div>

                    <div class="center">
                        <a href="javascript:history.back()" class="btn btn-grey">
                            <i class="ace-icon fa fa-arrow-left"></i>
                            """),_display_(/*24.30*/Messages("btn.back")),format.raw/*24.50*/("""
                        """),format.raw/*25.25*/("""</a>

                        <a href='"""),_display_(/*27.35*/routes/*27.41*/.App.calendar("TODAY")),format.raw/*27.63*/("""' class="btn btn-primary">
                            <i class="ace-icon fa fa-calendar-o"></i>
                            """),_display_(/*29.30*/Messages("nav.cal")),format.raw/*29.49*/("""
                        """),format.raw/*30.25*/("""</a>
                    </div>
                </div>
            </div>
                <!-- /section:pages/error -->
                <!-- PAGE CONTENT ENDS -->
        </div><!-- /.col -->
    </div> <!-- /.row -->
""")))}/*38.2*/ {_display_(Seq[Any](format.raw/*38.4*/("""
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 11:42:41 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/error404.scala.html
                  HASH: d48439c7d8bb6e93f7539640d089754be084a51a
                  MATRIX: 801->1|813->6|845->30|856->33|895->35|914->37|952->39|983->44|1609->643|1649->662|1978->964|2019->984|2072->1009|2139->1049|2154->1055|2197->1077|2350->1203|2390->1222|2443->1247|2680->1466|2719->1468
                  LINES: 29->1|29->1|29->1|29->1|29->1|30->2|30->2|31->3|45->17|45->17|52->24|52->24|53->25|55->27|55->27|55->27|57->29|57->29|58->30|66->38|66->38
                  -- GENERATED --
              */
          