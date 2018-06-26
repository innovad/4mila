import {Injectable} from "@angular/core";
import {TranslationService} from "path-framework/app/path-framework/service/translation.service"

@Injectable()
export class _4milaTranslationService extends TranslationService {

    public getSupportedLanguageCodes() : string[] {
        return ["en", "de", "it", "nl"];
    }

    protected getTranslation(key:string) : string {
        let myTranslations = this.createTranslationMap(this.get4milaTranslations());
        // prefer custom translations
        if (myTranslations.get(key) == null) {
            return super.getTranslation(key);
        }
        return myTranslations.get(key);
    }

    private get4milaTranslations() {
        let languageCode: string = this.getUserLanguage();

        // put additional application translations here
        // TODO: switch on language if (languageCode == "de")
        return {
            "Admin": "Admin",
            "AddClass": "Add Class",
            "AddControl": "Add Control",
            "Birthdate": "Birthdate",
            "Class": "Class",
            "Classes": "Classes",
            "Control": "Control",
            "Controls": "Controls",
            "Course": "Course",
            "Courses": "Courses",
            "Entry": "Entry",
            "EditCourse": "Edit Course",
            "EditEvent": "Edit Event",
            "Event": "Event",
            "Events": "Events",
            "FamilyName": "Family Name",
            "FirstName": "First Name",
            "Latest": "Latest",
            "Name": "Name",
            "NewEvent": "New Event",
            "NewClass": "New Class",
            "NewControl": "New Control",
            "NewCourse": "New Course",
            "NewRunner": "New Runner",
            "NotYetImplemented": "This function is not yet implemented.",
            "Number": "Number",
            "Results": "Results",
            "Runner": "Runner",
            "Runners": "Runners",
            "SortOrder": "Sort Order"
        }
    }
}