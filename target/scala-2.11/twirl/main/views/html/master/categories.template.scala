
package views.html.master

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
object categories extends BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with play.twirl.api.Template0[play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply():play.twirl.api.HtmlFormat.Appendable = {
      _display_ {

Seq[Any](format.raw/*1.1*/("""<ul class="nav nav-list">

"""),_display_(/*3.2*/for(cat <- dto.Category.values()) yield /*3.35*/ {_display_(Seq[Any](format.raw/*3.37*/("""
    """),_display_(/*4.6*/if(!cat.equals(dto.Category.TENT))/*4.40*/ {_display_(Seq[Any](format.raw/*4.42*/("""
        """),format.raw/*5.9*/("""<li>
            <a href="#"""),_display_(/*6.24*/cat),format.raw/*6.27*/("""">
                <span class="menu-text">"""),_display_(/*7.42*/Messages(cat.toString())),format.raw/*7.66*/("""</span>
            </a>
        </li>
    """)))}),format.raw/*10.6*/("""
""")))}),format.raw/*11.2*/("""

"""),format.raw/*13.1*/("""</ul>

<div class="sidebar-toggle">
    <i class="ace-icon fa fa-cubes"></i>
</div>"""))}
  }

  def render(): play.twirl.api.HtmlFormat.Appendable = apply()

  def f:(() => play.twirl.api.HtmlFormat.Appendable) = () => apply()

  def ref: this.type = this

}
              /*
                  -- GENERATED --
                  DATE: Mon Mar 09 21:31:40 CET 2015
                  SOURCE: C:/Users/MiHu/Documents/projects/is-klost/is-klost/app/views/master/categories.scala.html
                  HASH: c43860f56cad0e933bb43487f9e27093384517db
                  MATRIX: 810->0|863->28|911->61|950->63|981->69|1023->103|1062->105|1097->114|1151->142|1174->145|1244->189|1288->213|1362->257|1394->259|1423->261
                  LINES: 29->1|31->3|31->3|31->3|32->4|32->4|32->4|33->5|34->6|34->6|35->7|35->7|38->10|39->11|41->13
                  -- GENERATED --
              */
          