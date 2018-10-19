/* check GUI model validity */
import {GuiModel} from "../app/gui-model/guimodel";

describe("Form Reference Test", function () {
    it("Form Reference Test", function () {

        const guiModel = new GuiModel().guiModel;
        const forms: string[] = [];
        const errors: string[] = [];

        for (const form of guiModel.application.formList) {
            forms.push(form.id);
        }

        for (const page of guiModel.application.pageList) {
            for (const element of page.elementList) {
                if (element.hasOwnProperty("form") && element["form"]["form"] != null && forms.indexOf(element["form"]["form"]) === -1) {
                    errors.push("missing form " + element["form"]["form"] + " on " + element["name"] + " (" + element["type"] + ")");
                }
            }
        }

        console.log(errors);
        expect(errors.length).toBe(0, errors);
    });
});


describe("Page Reference Test", function () {
    it("Page Reference Test", function () {

        const guiModel = new GuiModel().guiModel;
        const pages: string[] = [];
        const errors: string[] = [];

        for (const page of guiModel.application.pageList) {
            pages.push(page.id);
        }

        for (const page of guiModel.application.pageList) {
            for (const element of page.elementList) {
                if (element.hasOwnProperty("page") && pages.indexOf(element["page"]) === -1) {
                    errors.push("missing page " + element["page"] + " on " + element["name"]);
                }
            }
        }

        console.log(errors);
        expect(errors.length).toBe(0, errors);
    });
});
