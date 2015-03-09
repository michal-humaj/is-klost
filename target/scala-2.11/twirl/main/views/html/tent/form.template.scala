
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
object form extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template1[Long,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tentId: Long):play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.16*/("""

"""),format.raw/*3.1*/("""<div class="form-group" id="tentId" data-tentId=""""),_display_(/*3.51*/tentId),format.raw/*3.57*/("""">
    <label class="col-sm-2 control-label no-padding-right">"""),_display_(/*4.61*/Messages("lbl.name")),format.raw/*4.81*/("""</label>

    <div class="col-sm-7">
        <input name="name" placeholder="Stan pagoda" class="form-control" autocomplete="off"
        required data-bind="value: name">
    </div>
</div>

<h4 class="col-sm-offset-2 header blue lighter smaller">"""),_display_(/*12.58*/Messages("h.tentItems")),format.raw/*12.81*/("""</h4>

<div data-bind="foreach: accessories">
    <div class="form-group" data-bind="attr: """),format.raw/*15.46*/("""{"""),format.raw/*15.47*/(""" """),format.raw/*15.48*/("""class: itemName.isValid() ? 'form-group' : 'form-group has-info' """),format.raw/*15.113*/("""}"""),format.raw/*15.114*/("""">
        <div class="col-sm-offset-2 col-sm-7">
            <input class="form-control autocomplete" placeholder="Stolička plastová"
            data-bind="value: itemName, valueUpdate: 'blur' ">
        </div>

        <input type="hidden" data-bind="attr: """),format.raw/*21.47*/("""{"""),format.raw/*21.48*/(""" """),format.raw/*21.49*/("""name: fieldItem """),format.raw/*21.65*/("""}"""),format.raw/*21.66*/(""", value: $root.itemIdMap()[itemName()] " >

        <div class="col-sm-2">
            <input class="form-control" placeholder="18" autocomplete="off" required type="number" min="1" step="1"
            data-bind="attr: """),format.raw/*25.30*/("""{"""),format.raw/*25.31*/(""" """),format.raw/*25.32*/("""name: fieldAmount """),format.raw/*25.50*/("""}"""),format.raw/*25.51*/(""", value: amount ">
        </div>

        <div class="col-sm-1">
            <a type="button" class="btn btn-white btn-danger" data-bind="click: $parent.removeAccessory">
                <span class="fa fa-times"></span>
            </a>
        </div>
    </div>
</div>

<div class="form-group">
    <div class="col-sm-offset-11 col-sm-1">
        <a type="button" class="btn btn-primary btn-sm" data-bind="click: addAccessory">
            <span class="fa fa-plus "></span>
        </a>
    </div>
</div>"""))}
  }

  def render(tentId:Long): play.twirl.api.HtmlFormat.Appendable = apply(tentId)

  def f:((Long) => play.twirl.api.HtmlFormat.Appendable) = (tentId) => apply(tentId)

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Mar 09 21:31:40 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/tent/form.scala.html
                  HASH: 97591691ad0924253a9ea7b20c2edf8e8bdd93fc
                  MATRIX: 725->1|827->15|855->17|931->67|957->73|1046->136|1086->156|1361->404|1405->427|1524->518|1553->519|1582->520|1676->585|1706->586|1994->846|2023->847|2052->848|2096->864|2125->865|2373->1085|2402->1086|2431->1087|2477->1105|2506->1106
                  LINES: 26->1|29->1|31->3|31->3|31->3|32->4|32->4|40->12|40->12|43->15|43->15|43->15|43->15|43->15|49->21|49->21|49->21|49->21|49->21|53->25|53->25|53->25|53->25|53->25
                  -- GENERATED --
              */
          