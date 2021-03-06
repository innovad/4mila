import {Injectable} from "@angular/core";
import {TranslationService} from "path-framework/app/path-framework/service/translation.service";

@Injectable()
// tslint:disable-next-line:class-name
export class _4milaTranslationService extends TranslationService {

    public getSupportedLanguageCodes(): string[] {
        return ["en", "de", "it", "nl"];
    }

    protected getTranslation(key: string): string {
        const myTranslations = this.createTranslationMap(this.get4milaTranslations());
        // prefer custom translations
        if (myTranslations.get(key) == null) {
            return super.getTranslation(key);
        }
        return myTranslations.get(key);
    }

    private get4milaTranslations() {
        const languageCode: string = this.getUserLanguage();

        // put additional application translations here
        // TODO: switch on language if (languageCode == "de")
        return {
            "Admin": "Admin",
            "AddClass": "Add Class",
            "AddControl": "Add Control",
            "All": "All",
            "Birthdate": "Birthdate",
            "BrowseEntries": "Browse Entries",
            "BrowseResults": "Browse Results",
            "City": "City",
            "Class": "Class",
            "Classes": "Classes",
            "Climb": "Climb",
            "Control": "Control",
            "Controls": "Controls",
            "Course": "Course",
            "Courses": "Courses",
            "Ecard": "E-Card",
            "Ecards": "E-Cards",
            "Email": "E-Mail",
            "Entry": "Entry",
            "EditCourse": "Edit Course",
            "EditEvent": "Edit Event",
            "EditRace": "Edit Race",
            "Event": "Event",
            "Events": "Events",
            "FamilyName": "Family Name",
            "FirstName": "First Name",
            "File": "File",
            "ID": "ID",
            "InsertEcard": "Please insert your E-Card",
            "Import": "Import",
            "Latest": "Latest",
            "Length": "Length",
            "Name": "Name",
            "NewEcard": "New E-Card",
            "NewEvent": "New Event",
            "NewClass": "New Class",
            "NewControl": "New Control",
            "NewCourse": "New Course",
            "NewRunner": "New Runner",
            "NotYetImplemented": "This function is not yet implemented.",
            "Number": "Number",
            "Race": "Race",
            "Results": "Results",
            "Runner": "Runner",
            "Runners": "Runners",
            "Sex": "Sex",
            "SetCurrentEvent": "Set as current Event",
            "SortOrder": "Sort Order",
            "Status": "Status",
            "TestECard": "Simulate E-Card",
            "Type": "Type",
            "YearOfBirth": "Year of birth"
        };
    }
}
