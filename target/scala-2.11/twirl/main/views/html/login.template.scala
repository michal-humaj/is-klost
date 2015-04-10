
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
                                        """),_display_(/*41.42*/forProviders()/*41.56*/ { p =>_display_(Seq[Any](format.raw/*41.63*/("""
                                            """),format.raw/*42.45*/("""<a class="btn btn-danger" href=""""),_display_(/*42.78*/p/*42.79*/.getUrl()),format.raw/*42.88*/("""">
                                                <i class="ace-icon fa fa-google-plus"></i>
                                            </a>
                                        """)))}),format.raw/*45.42*/("""
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
                  DATE: Fri Apr 10 11:59:43 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/login.scala.html
                  HASH: bc3e5b86ec3370d24e314d65d73cc07ddb86e44b
                  MATRIX: 841->49|853->54|906->99|941->126|980->128|1012->134|2260->1355|2300->1374|2370->1416|2526->1545|2540->1550|2574->1563|2650->1612|2672->1625|2720->1635|2798->1686|2823->1702|2863->1704|2945->1759|2994->1787|3076->1838|3154->1885|3224->1927|3446->2122|3469->2136|3514->2143|3588->2189|3648->2222|3658->2223|3688->2232|3906->2419|3976->2461|4428->2895|4467->2897
                  LINES: 29->3|29->3|29->3|29->3|29->3|30->4|53->27|53->27|54->28|56->30|56->30|56->30|58->32|58->32|58->32|59->33|59->33|59->33|60->34|60->34|61->35|62->36|63->37|67->41|67->41|67->41|68->42|68->42|68->42|68->42|71->45|72->46|84->58|84->58
                  -- GENERATED --
              */
          