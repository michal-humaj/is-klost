
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
object storeAdmin extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(date: String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),_display_(/*3.2*/views/*3.7*/.html.master.main(Messages("nav.store"))/*3.47*/(1)/*3.50*/ {_display_(Seq[Any](format.raw/*3.52*/("""

    """),_display_(/*5.6*/views/*5.11*/.html.master.datepicker()),format.raw/*5.36*/("""
    """),_display_(/*6.6*/views/*6.11*/.html.master.categories()),format.raw/*6.36*/("""
""")))}/*7.2*/ {_display_(Seq[Any](format.raw/*7.4*/("""
    """),_display_(/*8.6*/views/*8.11*/.html.item.modalNew()),format.raw/*8.32*/("""

    """),_display_(/*10.6*/views/*10.11*/.html.item.modalEdit()),format.raw/*10.33*/("""

    """),_display_(/*12.6*/views/*12.11*/.html.item.modalImport()),format.raw/*12.35*/("""

    """),_display_(/*14.6*/views/*14.11*/.html.item.modalExport()),format.raw/*14.35*/("""

    """),_display_(/*16.6*/views/*16.11*/.html.item.modalDelete()),format.raw/*16.35*/("""

    """),format.raw/*18.5*/("""<div class="row">
        <div class="col-xs-12">

            <div class="widget-box " id="widgetEvents" data-date=""""),_display_(/*21.68*/date),format.raw/*21.72*/("""">
                <div class="widget-header widget-header-flat ">
                    <h4 class="widget-title">
                        <i class="ace-icon fa fa-calendar-o "></i>
                            <!--ko text: headingWidgetEvents--><!--/ko-->
                    </h4>

                    <div class="widget-toolbar">
                        <a href="#" data-action="collapse" id="btnCollapseEventsWidget">
                            <i class="ace-icon fa fa-chevron-up "></i>
                        </a>
                    </div>
                </div>

                <div class="widget-body">
                    <div class="widget-main no-padding">
                        <table class="table">
                            <thead class="thin-border-bottom">
                                <tr>
                                    <th>"""),_display_(/*40.42*/Messages("t.type")),format.raw/*40.60*/("""</th>
                                    <th>"""),_display_(/*41.42*/Messages("t.event")),format.raw/*41.61*/("""</th>
                                    <th class="thEventStartEnd">"""),_display_(/*42.66*/Messages("t.start")),format.raw/*42.85*/("""</th>
                                    <th class="thEventStartEnd">"""),_display_(/*43.66*/Messages("t.end")),format.raw/*43.83*/("""</th>
                                    <th>"""),_display_(/*44.42*/Messages("lbl.calcAvail")),format.raw/*44.67*/("""</th>
                                </tr>
                            </thead>
                            <tbody data-bind="foreach: events">
                                <tr>
                                    <td><span class="badge badgeAction" data-bind="text: Messages(eventType), attr: """),format.raw/*49.117*/("""{"""),format.raw/*49.118*/("""class: 'badge badge' + eventType """),format.raw/*49.151*/("""}"""),format.raw/*49.152*/(""""></span></td>
                                    <td data-bind="text: name"></td>
                                    <td data-bind="text: startTime"></td>
                                    <td data-bind="text: endTime"></td>
                                    <td class="tdSwitch">
                                        <label>
                                            <input class="ace ace-switch ace-switch-6" type="checkbox"
                                            data-bind="checked: calcAvail">
                                            <span class="lbl"></span>
                                        </label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div><!-- /.widget-main -->
                </div><!-- /.widget-body -->
            </div>

        </div>
    </div>

    <div class="space"></div>

    <div class="row">
        <div class="col-xs-12">

            <div class="widget-box widget-color-green2 light-border widgetContentWidth" id="widgetItems">
                <div class="widget-header widget-header-flat">
                    <h4 class="widget-title ">
                        <i class="ace-icon fa fa-cubes"></i>
                        """),_display_(/*79.26*/Messages("h.itemAvail")),format.raw/*79.49*/("""
                    """),format.raw/*80.21*/("""</h4>

                    <div class="widget-toolbar no-border">
                        <button class="btn btn-white btn-success btn-xs" id="btnModalNewItem" data-toggle="modal"
                        data-target="#modalNewItem" data-bind="click: modalAdd">
                            <b class="textGreen">"""),_display_(/*85.51*/Messages("btn.newItem")),format.raw/*85.74*/("""</b>
                        </button>
                    </div>
                </div>

                <div class="widget-body">
                    <div class="widget-main no-padding">

                        <table class="table table-striped table-bordered  tableNoBorder tableScrollable">
                            <thead class="thin-border-bottom">
                                <tr>
                                    <th class="thItemName">"""),_display_(/*96.61*/Messages("t.item")),format.raw/*96.79*/("""</th>
                                    <th class="thNumberValue">"""),_display_(/*97.64*/Messages("t.available")),format.raw/*97.87*/("""</th>
                                    <th class="thNumberValue">"""),_display_(/*98.64*/Messages("t.rented")),format.raw/*98.84*/("""</th>
                                    <th class="thNumberValue">"""),_display_(/*99.64*/Messages("t.reserved")),format.raw/*99.86*/("""</th>
                                    <th class="thItemControls">"""),_display_(/*100.65*/Messages("t.action")),format.raw/*100.85*/("""</th>
                                </tr>
                            </thead>

                            <tbody data-bind="foreach: items" data-spy="scroll">

                                <tr data-bind="attr: """),format.raw/*106.54*/("""{"""),format.raw/*106.55*/(""" """),format.raw/*106.56*/("""id: category, class: $parent.items()[$index()].category !== $parent.items()[$index()+1 < $parent.items().length-1 ? $index()+1 : $parent.items().length-1].category ? 'lastInCategoryA' : ''"""),format.raw/*106.244*/("""}"""),format.raw/*106.245*/("""">
                                    <td class="thItemName" data-bind="text: name"></td>
                                    <td class="thNumberValue" data-bind="attr: """),format.raw/*108.80*/("""{"""),format.raw/*108.81*/("""class: available < 0 ? 'thNumberValue textRed' : 'thNumberValue' """),format.raw/*108.146*/("""}"""),format.raw/*108.147*/(""""><b data-bind="text: available"></b></td>
                                    <td class="thNumberValue textRented"><b data-bind="text: rented !== 0 ? rented : '.' "></b></td>
                                    <td class="thNumberValue textReserved"><b data-bind="text: reserved !== 0 ? reserved : '.' "></b></td>
                                    <td class="tdItemControls">
                                        <div class="action-buttons">
                                            <a class="textBlack tooltip-success linkImportItem" data-rel="tooltip"
                                            title='"""),_display_(/*114.53*/Messages("tooltip.import")),format.raw/*114.79*/("""' data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalImportItem">
                                                <i class="ace-icon fa fa-plus bigger-130"></i>
                                            </a>

                                            <a class="textBlack tooltip-warning linkExportItem" data-rel="tooltip"
                                            title='"""),_display_(/*120.53*/Messages("tooltip.export")),format.raw/*120.79*/("""' data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalExportItem">
                                                <i class="ace-icon fa fa-minus bigger-130"></i>
                                            </a>

                                            <a class="textBlack tooltip-info linkEditItem" data-rel="tooltip"
                                            title='"""),_display_(/*126.53*/Messages("tooltip.edit")),format.raw/*126.77*/("""' data-bind="click: $parent.edit"
                                            data-toggle="modal" data-target="#modalEditItem">
                                                <i class="ace-icon fa fa-pencil bigger-130"></i>
                                            </a>

                                            <a class="textBlack tooltip-error linkDeleteItem" data-rel="tooltip"
                                            title='"""),_display_(/*132.53*/Messages("tooltip.delete")),format.raw/*132.79*/("""' data-bind="click: $parent.edit"
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

        </div>
    </div>
""")))}/*150.2*/ {_display_(Seq[Any](format.raw/*150.4*/("""
    """),format.raw/*151.5*/("""<script src='"""),_display_(/*151.19*/routes/*151.25*/.Assets.at("js/storeCommon.js")),format.raw/*151.56*/("""'></script>
    <script src='"""),_display_(/*152.19*/routes/*152.25*/.Assets.at("js/storeAdmin.js")),format.raw/*152.55*/("""'></script>
""")))}))}
  }

  def render(date:String): play.twirl.api.HtmlFormat.Appendable = apply(date)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (date) => apply(date)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 16:58:07 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/storeAdmin.scala.html
                  HASH: b83af0e020de84df8cb005c4f4846d5d94d5f2b2
                  MATRIX: 728->1|830->15|860->20|872->25|920->65|931->68|970->70|1004->79|1017->84|1062->109|1094->116|1107->121|1152->146|1172->149|1210->151|1242->158|1255->163|1296->184|1331->193|1345->198|1388->220|1423->229|1437->234|1482->258|1517->267|1531->272|1576->296|1611->305|1625->310|1670->334|1705->342|1853->463|1878->467|2780->1342|2819->1360|2894->1408|2934->1427|3033->1499|3073->1518|3172->1590|3210->1607|3285->1655|3331->1680|3663->1983|3693->1984|3755->2017|3785->2018|5155->3361|5199->3384|5249->3406|5592->3722|5636->3745|6130->4212|6169->4230|6266->4300|6310->4323|6407->4393|6448->4413|6545->4483|6588->4505|6687->4576|6729->4596|6981->4819|7011->4820|7041->4821|7259->5009|7290->5010|7491->5182|7521->5183|7616->5248|7647->5249|8296->5870|8344->5896|8820->6344|8868->6370|9340->6814|9386->6838|9860->7284|9908->7310|10563->7946|10603->7948|10637->7954|10679->7968|10695->7974|10748->8005|10807->8036|10823->8042|10875->8072
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7|36->8|36->8|36->8|38->10|38->10|38->10|40->12|40->12|40->12|42->14|42->14|42->14|44->16|44->16|44->16|46->18|49->21|49->21|68->40|68->40|69->41|69->41|70->42|70->42|71->43|71->43|72->44|72->44|77->49|77->49|77->49|77->49|107->79|107->79|108->80|113->85|113->85|124->96|124->96|125->97|125->97|126->98|126->98|127->99|127->99|128->100|128->100|134->106|134->106|134->106|134->106|134->106|136->108|136->108|136->108|136->108|142->114|142->114|148->120|148->120|154->126|154->126|160->132|160->132|178->150|178->150|179->151|179->151|179->151|179->151|180->152|180->152|180->152
                  -- GENERATED --
              */
          