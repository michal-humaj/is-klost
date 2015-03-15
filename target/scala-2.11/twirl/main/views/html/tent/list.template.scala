
package views.html.tent

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
object list extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[List[Tent],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tents: List[Tent]):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.21*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("nav.tents"))/*3.47*/(2)/*3.50*/ {_display_(Seq[Any](format.raw/*3.52*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),_display_(/*5.6*/views/*5.11*/.html.tent.modalDelete()),format.raw/*5.35*/("""

    """),format.raw/*7.5*/("""<div class="row">
        <div class="col-xs-12">
            """),_display_(/*9.14*/if(flash.containsKey("success"))/*9.46*/ {_display_(Seq[Any](format.raw/*9.48*/("""
                """),format.raw/*10.17*/("""<div class="alert alert-success">
                """),_display_(/*11.18*/flash/*11.23*/.get("success")),format.raw/*11.38*/("""
                """),format.raw/*12.17*/("""</div>
            """)))}),format.raw/*13.14*/("""
            """),_display_(/*14.14*/if(flash.containsKey("error"))/*14.44*/ {_display_(Seq[Any](format.raw/*14.46*/("""
                """),format.raw/*15.17*/("""<div class="alert alert-danger">
                """),_display_(/*16.18*/flash/*16.23*/.get("error")),format.raw/*16.36*/("""
                """),format.raw/*17.17*/("""</div>
            """)))}),format.raw/*18.14*/("""

            """),format.raw/*20.13*/("""<div class="widget-box light-border widgetTentList">

                <form method="get" action=""""),_display_(/*22.45*/routes/*22.51*/.Tents.neu),format.raw/*22.61*/("""">
                    <div class="widget-header widget-header-flat">
                        <h4 class="widget-title ">
                        """),_display_(/*25.26*/Messages("h.tents")),format.raw/*25.45*/("""
                        """),format.raw/*26.25*/("""</h4>
                        <div class="widget-toolbar no-border">
                            <button type="submit" class="btn btn-white btn-primary btn-xs"><b>"""),_display_(/*28.96*/Messages("btn.newTent")),format.raw/*28.119*/("""</b></button>
                        </div>
                    </div>
                </form>

                <div class="widget-body">
                    <div class="widget-main no-padding">

                        <table class="table">
                            <thead class="thin-border-bottom">
                                <tr>
                                    <th>"""),_display_(/*39.42*/Messages("t.tent")),format.raw/*39.60*/("""</th>
                                    <th></th>
                                </tr>
                            </thead>

                            <tbody>
                            """),_display_(/*45.30*/for(tent <- tents) yield /*45.48*/ {_display_(Seq[Any](format.raw/*45.50*/("""
                                """),format.raw/*46.33*/("""<tr>
                                    <td>"""),_display_(/*47.42*/tent/*47.46*/.name),format.raw/*47.51*/("""</td>

                                    <td class="align-right">
                                        <div class="action-buttons">

                                            <a class="text-primary" href=""""),_display_(/*52.76*/routes/*52.82*/.Tents.edit(tent.id)),format.raw/*52.102*/("""">
                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                                """),_display_(/*54.50*/Messages("btn.edit")),format.raw/*54.70*/("""
                                            """),format.raw/*55.45*/("""</a>

                                            <a class="text-danger linkDeleteTent" data-toggle="modal" href=""
                                            data-deleteUrl=""""),_display_(/*58.62*/routes/*58.68*/.Tents.delete(tent.id)),format.raw/*58.90*/(""""
                                            data-tentName=""""),_display_(/*59.61*/tent/*59.65*/.name),format.raw/*59.70*/("""" data-target="#modalDeleteTent">
                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                                """),_display_(/*61.50*/Messages("btn.delete")),format.raw/*61.72*/("""
                                            """),format.raw/*62.45*/("""</a>

                                        </div>
                                    </td>
                                </tr>
                            """)))}),format.raw/*67.30*/("""
                            """),format.raw/*68.29*/("""</tbody>

                        </table>

                    </div><!-- /.widget-main -->
                </div><!-- /.widget-body -->
            </div><!-- /.widget-box -->

            <!-- page content goes here -->
        </div>
    </div>
""")))}/*79.2*/ {_display_(Seq[Any](format.raw/*79.4*/("""
    """),format.raw/*80.5*/("""<script src='"""),_display_(/*80.19*/routes/*80.25*/.Assets.at("js/tentList.js")),format.raw/*80.53*/("""'></script>
""")))}))}
  }

  def render(tents:List[Tent]): play.twirl.api.HtmlFormat.Appendable = apply(tents)

  def f:((List[Tent]) => play.twirl.api.HtmlFormat.Appendable) = (tents) => apply(tents)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 19:57:55 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/tent/list.scala.html
                  HASH: c05bc9f632ea52e38bc3108f7d448fd2a53076fb
                  MATRIX: 731->1|838->20|868->25|880->30|928->70|939->73|978->75|998->78|1036->80|1068->87|1081->92|1125->116|1159->124|1250->189|1290->221|1329->223|1375->241|1454->293|1468->298|1504->313|1550->331|1602->352|1644->367|1683->397|1723->399|1769->417|1847->468|1861->473|1895->486|1941->504|1993->525|2037->541|2164->641|2179->647|2210->657|2386->806|2426->825|2480->851|2673->1017|2718->1040|3140->1435|3179->1453|3405->1652|3439->1670|3479->1672|3541->1706|3615->1753|3628->1757|3654->1762|3899->1980|3914->1986|3956->2006|4134->2157|4175->2177|4249->2223|4456->2403|4471->2409|4514->2431|4604->2494|4617->2498|4643->2503|4853->2686|4896->2708|4970->2754|5168->2921|5226->2951|5505->3212|5544->3214|5577->3220|5618->3234|5633->3240|5682->3268
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|32->4|32->4|33->5|33->5|33->5|35->7|37->9|37->9|37->9|38->10|39->11|39->11|39->11|40->12|41->13|42->14|42->14|42->14|43->15|44->16|44->16|44->16|45->17|46->18|48->20|50->22|50->22|50->22|53->25|53->25|54->26|56->28|56->28|67->39|67->39|73->45|73->45|73->45|74->46|75->47|75->47|75->47|80->52|80->52|80->52|82->54|82->54|83->55|86->58|86->58|86->58|87->59|87->59|87->59|89->61|89->61|90->62|95->67|96->68|107->79|107->79|108->80|108->80|108->80|108->80
                  -- GENERATED --
              */
          