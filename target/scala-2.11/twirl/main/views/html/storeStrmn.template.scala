
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
object storeStrmn extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](_display_(/*1.2*/views/*1.7*/.html.master.main(Messages("nav.store"))/*1.47*/(1)/*1.50*/ {_display_(Seq[Any](format.raw/*1.52*/("""

    """),_display_(/*3.6*/views/*3.11*/.html.master.categories()),format.raw/*3.36*/("""
""")))}/*4.2*/ {_display_(Seq[Any](format.raw/*4.4*/("""
    """),_display_(/*5.6*/views/*5.11*/.html.item.modalNew()),format.raw/*5.32*/("""

    """),_display_(/*7.6*/views/*7.11*/.html.item.modalEdit()),format.raw/*7.33*/("""

    """),_display_(/*9.6*/views/*9.11*/.html.item.modalImport()),format.raw/*9.35*/("""

    """),_display_(/*11.6*/views/*11.11*/.html.item.modalExport()),format.raw/*11.35*/("""

    """),_display_(/*13.6*/views/*13.11*/.html.item.modalDelete()),format.raw/*13.35*/("""

    """),format.raw/*15.5*/("""<div class="row">
        <div class="col-xs-12">

            <div class="widget-box light-border widgetContentWidth">
                <div class="widget-header widget-header-flat">
                    <h4 class="widget-title ">
                        <i class="ace-icon fa fa-cubes"></i>
                        """),_display_(/*22.26*/Messages("h.items")),format.raw/*22.45*/("""
                    """),format.raw/*23.21*/("""</h4>

                    <div class="widget-toolbar no-border">
                        <button class="btn btn-white btn-primary btn-xs" id="btnModalNewItem" data-toggle="modal"
                        data-target="#modalNewItem" data-bind="click: modalAdd"><b>"""),_display_(/*27.85*/Messages("btn.newItem")),format.raw/*27.108*/("""</b></button>
                    </div>
                </div>

                <div class="widget-body">
                    <div class="widget-main no-padding">

                        <table class="table table-striped table-bordered tableNoBorder tableScrollable">
                            <thead class="thin-border-bottom">
                                <tr>
                                    <th class="thItemName">"""),_display_(/*37.61*/Messages("t.item")),format.raw/*37.79*/("""</th>
                                    <th class="thNumberValue">"""),_display_(/*38.64*/Messages("lbl.amount")),format.raw/*38.86*/("""</th>
                                    <th class="thNumberValue">"""),_display_(/*39.64*/Messages("lbl.weight")),format.raw/*39.86*/("""</th>
                                    <th class="thItemControls">"""),_display_(/*40.65*/Messages("t.action")),format.raw/*40.85*/("""</th>
                                </tr>
                            </thead>

                            <tbody data-bind="foreach: items" data-spy="scroll">

                                <tr data-bind="attr: """),format.raw/*46.54*/("""{"""),format.raw/*46.55*/(""" """),format.raw/*46.56*/("""id: category, class: $parent.items()[$index()].category !== $parent.items()[$index()+1 < $parent.items().length-1 ? $index()+1 : $parent.items().length-1].category ? 'lastInCategory' : ''"""),format.raw/*46.243*/("""}"""),format.raw/*46.244*/("""">
                                    <td data-bind="text: name" class="thItemName"></td>
                                    <td data-bind="text: amount" class="thNumberValue"></td>
                                    <td data-bind="text: weight" class="thNumberValue"></td>
                                    <td class="tdItemControls">
                                        <div class="action-buttons">
                                            <a class="textBlack tooltip-success linkImportItem" data-rel="tooltip"
                                            title='"""),_display_(/*53.53*/Messages("tooltip.import")),format.raw/*53.79*/("""' data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalImportItem">
                                                <i class="ace-icon fa fa-plus bigger-130"></i>
                                            </a>

                                            <a class="textBlack tooltip-warning linkExportItem" data-rel="tooltip"
                                            title='"""),_display_(/*59.53*/Messages("tooltip.export")),format.raw/*59.79*/("""'  data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalExportItem">
                                                <i class="ace-icon fa fa-minus bigger-130"></i>
                                            </a>

                                            <a class="textBlack tooltip-info linkEditItem" data-rel="tooltip"
                                            title='"""),_display_(/*65.53*/Messages("tooltip.edit")),format.raw/*65.77*/("""' data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalEditItem">
                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="textBlack tooltip-error linkDeleteItem" data-rel="tooltip"
                                            title='"""),_display_(/*71.53*/Messages("tooltip.delete")),format.raw/*71.79*/("""' data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalDeleteItem">
                                                <i class="ace-icon fa fa-trash-o bigger-130"></i>
                                            </a>
                                        </div>
                                    </td>
                                </tr>

                            </tbody>
                        </table>
                    </div><!-- /.widget-main -->
                </div><!-- /.widget-body -->
            </div>
        </div><!-- /.col -->
    </div> <!-- /.row -->
""")))}/*86.2*/ {_display_(Seq[Any](format.raw/*86.4*/("""
    """),format.raw/*87.5*/("""<script src='"""),_display_(/*87.19*/routes/*87.25*/.Assets.at("js/storeCommon.js")),format.raw/*87.56*/("""'></script>
    <script src='"""),_display_(/*88.19*/routes/*88.25*/.Assets.at("js/storeStrmn.js")),format.raw/*88.55*/("""'></script>
""")))}))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Tue Apr 14 14:48:11 CEST 2015
                  SOURCE: C:/Users/MiHu/projects/is-klost/is-klost/app/views/storeStrmn.scala.html
                  HASH: 0ecc5cd3726667e165465811943a30d8018375b8
                  MATRIX: 803->1|815->6|863->46|874->49|913->51|947->60|960->65|1005->90|1025->93|1063->95|1095->102|1108->107|1149->128|1183->137|1196->142|1238->164|1272->173|1285->178|1329->202|1364->211|1378->216|1423->240|1458->249|1472->254|1517->278|1552->286|1902->609|1942->628|1992->650|2287->918|2332->941|2799->1381|2838->1399|2935->1469|2978->1491|3075->1561|3118->1583|3216->1654|3257->1674|3508->1897|3537->1898|3566->1899|3782->2086|3812->2087|4423->2671|4470->2697|4945->3145|4992->3171|5464->3616|5509->3640|5982->4086|6029->4112|6706->4771|6745->4773|6778->4779|6819->4793|6834->4799|6886->4830|6944->4861|6959->4867|7010->4897
                  LINES: 29->1|29->1|29->1|29->1|29->1|31->3|31->3|31->3|32->4|32->4|33->5|33->5|33->5|35->7|35->7|35->7|37->9|37->9|37->9|39->11|39->11|39->11|41->13|41->13|41->13|43->15|50->22|50->22|51->23|55->27|55->27|65->37|65->37|66->38|66->38|67->39|67->39|68->40|68->40|74->46|74->46|74->46|74->46|74->46|81->53|81->53|87->59|87->59|93->65|93->65|99->71|99->71|114->86|114->86|115->87|115->87|115->87|115->87|116->88|116->88|116->88
                  -- GENERATED --
              */
          