
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
import com.feth.play.module.pa.views.html._
/**/
object login extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*3.2*/views/*3.7*/.html.master.imports(Messages("title.login"))/*3.52*/("login-layout blur-login")/*3.79*/ {_display_(Seq[Any](format.raw/*3.81*/("""
    """),format.raw/*4.5*/("""<div class="main-container">
        <div class="main-content">
            <div class="row">
                <div class="col-sm-10 col-sm-offset-1">
                    <div class="login-container">

                        <div class="center">
                            <h1>
                                <i class="ace-icon fa fa-leaf green"></i>
                                <span class="red">IS</span>
                                <span class="white" id="id-text2">Klost</span>
                            </h1>
                            <h4 class="blue" id="id-company-text">&copy;  TECHNOĽAN - KLOST, s.r.o.</h4>
                        </div>

                        <div class="space-6"></div>

                        <div class="position-relative">
                            <div id="login-box" class="login-box visible widget-box no-border">
                                <div class="widget-body">
                                    <div class="widget-main">
                                        <h4 class="header blue lighter bigger">
                                            <i class="ace-icon fa fa-key green"></i>
                                            """),_display_(/*27.46*/Messages("p.login")),format.raw/*27.65*/("""
                                        """),format.raw/*28.41*/("""</h4>
                                        <div class="alert-message warning">
                                            """),_display_(/*30.46*/flash/*30.51*/.get("flash")),format.raw/*30.64*/("""

                                            """),_display_(/*32.46*/currentAuth()/*32.59*/ { auth =>_display_(Seq[Any](format.raw/*32.69*/("""
                                                """),_display_(/*33.50*/if(auth != null)/*33.66*/ {_display_(Seq[Any](format.raw/*33.68*/("""
                                                    """),_display_(/*34.54*/Messages("err.unauthorized")),format.raw/*34.82*/("""
                                                """)))}),format.raw/*35.50*/("""
                                            """)))}),format.raw/*36.46*/("""
                                        """),format.raw/*37.41*/("""</div>
                                        <div class="space-6"></div>

                                        <div class="social-login center">
                                            """),_display_(/*41.46*/forProviders()/*41.60*/ { p =>_display_(Seq[Any](format.raw/*41.67*/("""
                                                """),format.raw/*42.49*/("""<a class="btn btn-danger" href=""""),_display_(/*42.82*/p/*42.83*/.getUrl()),format.raw/*42.92*/("""">
                                                    <i class="ace-icon fa fa-google-plus"></i>
                                                </a>
                                            """)))}),format.raw/*45.46*/("""
                                        """),format.raw/*46.41*/("""</div>
                                    </div><!-- /.widget-main -->
                                </div><!-- /.widget-body -->
                            </div><!-- /.login-box -->
                        </div><!-- /.position-relative -->

                    </div>
                </div><!-- /.col -->
            </div><!-- /.row -->
        </div><!-- /.main-content -->
    </div> <!-- /.main-container -->

""")))}/*58.2*/ {_display_(Seq[Any](format.raw/*58.4*/("""

""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Feb 02 11:30:58 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/login.scala.html
                  HASH: 9eebd2a20aaf9cb08a093cc3312b7d31f89e0d45
                  MATRIX: 841->47|853->52|906->97|941->124|980->126|1011->131|2236->1329|2276->1348|2345->1389|2499->1516|2513->1521|2547->1534|2621->1581|2643->1594|2691->1604|2768->1654|2793->1670|2833->1672|2914->1726|2963->1754|3044->1804|3121->1850|3190->1891|3412->2086|3435->2100|3480->2107|3557->2156|3617->2189|3627->2190|3657->2199|3884->2395|3953->2436|4393->2858|4432->2860
                  LINES: 29->3|29->3|29->3|29->3|29->3|30->4|53->27|53->27|54->28|56->30|56->30|56->30|58->32|58->32|58->32|59->33|59->33|59->33|60->34|60->34|61->35|62->36|63->37|67->41|67->41|67->41|68->42|68->42|68->42|68->42|71->45|72->46|84->58|84->58
                  -- GENERATED --
              */
          