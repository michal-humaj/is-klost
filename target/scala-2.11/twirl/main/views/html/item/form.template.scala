
package views.html.item

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
object form extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(selectId : String):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.21*/("""

"""),format.raw/*3.1*/("""<div class="form-group" data-bind="attr: """),format.raw/*3.42*/("""{"""),format.raw/*3.43*/(""" """),format.raw/*3.44*/("""class: item().category.isValid() ? 'form-group' : 'form-group has-info'  """),format.raw/*3.117*/("""}"""),format.raw/*3.118*/("""">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*4.61*/Messages("lbl.cat")),format.raw/*4.80*/("""</label>
    <div class="col-sm-6">
        <select name="category" id=""""),_display_(/*6.38*/selectId),format.raw/*6.46*/("""" class="form-control itemCategorySelect" data-bind="value: item().category">
        """),_display_(/*7.10*/for(cat <- dto.Category.values()) yield /*7.43*/ {_display_(Seq[Any](format.raw/*7.45*/("""
            """),_display_(/*8.14*/if(!cat.equals(dto.Category.TENT))/*8.48*/ {_display_(Seq[Any](format.raw/*8.50*/("""
                """),format.raw/*9.17*/("""<option value=""""),_display_(/*9.33*/cat),format.raw/*9.36*/("""">"""),_display_(/*9.39*/Messages(cat.toString())),format.raw/*9.63*/("""</option>
            """)))}),format.raw/*10.14*/("""
        """)))}),format.raw/*11.10*/("""
        """),format.raw/*12.9*/("""</select>
    </div>
    <div class="help-block col-sm-reset inline" data-bind="validationMessage: item().category"></div>
</div>

<div class="form-group" data-bind="attr: """),format.raw/*17.42*/("""{"""),format.raw/*17.43*/(""" """),format.raw/*17.44*/("""class: item().name.isValid() ? 'form-group' : 'form-group has-info' """),format.raw/*17.112*/("""}"""),format.raw/*17.113*/("""">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*18.61*/Messages("lbl.name")),format.raw/*18.81*/("""</label>
    <div class="col-sm-6">
        <input name="name" class="form-control" placeholder="Stolička plastová" data-bind="value: item().name" autocomplete="off">
    </div>
    <div class="help-block col-sm-reset inline" data-bind="validationMessage: item().name"></div>
</div>

<div class="form-group" data-bind="attr: """),format.raw/*25.42*/("""{"""),format.raw/*25.43*/(""" """),format.raw/*25.44*/("""class: item().amount.isValid() ? 'form-group' : 'form-group has-info' """),format.raw/*25.114*/("""}"""),format.raw/*25.115*/("""">
    <label class="col-sm-2 control-label no-padding-right"
        data-bind="text: item().category() === 'CARPET' ? Messages('lbl.length') : Messages('lbl.amount') ">
    </label>
    <div class="col-sm-3 controls">
        <div class="input-group">
            <input name="amount" class="form-control" placeholder="340" data-bind="value: item().amount" autocomplete="off">
            <span class="input-group-addon"
                data-bind="text: item().category() === 'CARPET' ? Messages('lbl.m') : Messages('lbl.pcs') ">
            </span>
        </div>
    </div>
    <div class="help-block col-sm-reset inline" data-bind="validationMessage: item().amount"></div>
</div>

<div class="form-group" data-bind="attr: """),format.raw/*40.42*/("""{"""),format.raw/*40.43*/(""" """),format.raw/*40.44*/("""class: item().weight.isValid() ? 'form-group' : 'form-group has-info'  """),format.raw/*40.115*/("""}"""),format.raw/*40.116*/("""">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*41.61*/Messages("lbl.weight")),format.raw/*41.83*/("""</label>
    <div class="col-sm-3 controls">
        <div class="input-group">
            <input name="weight" class="form-control" placeholder="2.85" data-bind="value: item().weight" autocomplete="off">
            <span class="input-group-addon"
                data-bind="text: item().category() === 'CARPET' ? Messages('lbl.kgpm') : Messages('lbl.kg') ">
            </span>
        </div>
    </div>
    <div class="help-block col-sm-reset inline" data-bind="validationMessage: item().weight"></div>
</div>"""))}
  }

  def render(selectId:String): play.twirl.api.HtmlFormat.Appendable = apply(selectId)

  def f:((String) => play.twirl.api.HtmlFormat.Appendable) = (selectId) => apply(selectId)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Sun Mar 15 13:23:43 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/item/form.scala.html
                  HASH: 55d7d768b87a8a2030b62bd82295e6d3d27ec142
                  MATRIX: 727->1|834->20|864->24|932->65|960->66|988->67|1089->140|1118->141|1208->205|1247->224|1348->299|1376->307|1490->395|1538->428|1577->430|1618->445|1660->479|1699->481|1744->499|1786->515|1809->518|1838->521|1882->545|1937->569|1979->580|2016->590|2221->767|2250->768|2279->769|2376->837|2406->838|2497->902|2538->922|2898->1254|2927->1255|2956->1256|3055->1326|3085->1327|3855->2069|3884->2070|3913->2071|4013->2142|4043->2143|4134->2207|4177->2229
                  LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|32->4|32->4|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|37->9|37->9|38->10|39->11|40->12|45->17|45->17|45->17|45->17|45->17|46->18|46->18|53->25|53->25|53->25|53->25|53->25|68->40|68->40|68->40|68->40|68->40|69->41|69->41
                  -- GENERATED --
              */
          