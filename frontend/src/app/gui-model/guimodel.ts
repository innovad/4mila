export class GuiModel {

    private _guiModel = {
        "application": {
            "title": "4mila",
            "formList": [
                {
                    "id": "OwnUserForm",
                    "title": "NotImplemented",
                    "formFieldList": [
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "EventForm",
                    "title": "Event",
                    "url": "/event",
                    "formFieldList": [
                        {
                            "id": "name",
                            "type": "text",
                            "name": "Name",
                            "required": true,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "RunnerForm",
                    "title": "Runner",
                    "url": "/runner",
                    "formFieldList": [
                        {
                            "id": "familyName",
                            "type": "text",
                            "name": "FamilyName",
                            "required": true
                        },
                        {
                            "id": "firstName",
                            "type": "text",
                            "name": "FirstName",
                            "required": true
                        },
                        {
                            "id": "birthDate",
                            "type": "date",
                            "name": "Birthdate",
                            "required": false
                        },
                        {
                            "id":   "defaultEcard",
                            "type": "autocomplete",
                            "name": "Ecard",
                            "wordSearchEnabled": true,
                            "defaultKey": "ecardKey",
                            "required": true,
                            "form": "EcardForm",
                            "url": "/ecard",
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "EcardForm",
                    "title": "Ecard",
                    "url": "/ecard",
                    "formFieldList": [
                        {
                            "id": "id",
                            "type": "text",
                            "name": "ID",
                            "required": true,
                            "width": 2,
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "RaceForm",
                    "title": "Race",
                    "url": "/race",
                    "formFieldList": [
                        {
                            "id":   "entry",
                            "type": "autocomplete",
                            "name": "Entry",
                            "wordSearchEnabled": true,
                            "defaultKey": "entryKey",
                            "required": true,
                            "form": "EntryForm",
                            "url": "/entry",
                            "width": 2
                        },
                        {
                            "id":   "runner",
                            "type": "autocomplete",
                            "name": "Runner",
                            "wordSearchEnabled": true,
                            "defaultKey": "runnerKey",
                            "required": true,
                            "form": "RunnerForm",
                            "url": "/runner",
                            "width": 2
                        },
                        {
                            "id":   "ecard",
                            "type": "autocomplete",
                            "name": "Ecard",
                            "wordSearchEnabled": true,
                            "defaultKey": "ecardKey",
                            "required": true,
                            "form": "EcardForm",
                            "url": "/ecard",
                            "width": 2
                        },
                        {
                            "id":   "eventClazz",
                            "type": "autocomplete",
                            "name": "Class",
                            "wordSearchEnabled": true,
                            "defaultKey": "eventClazzKey",
                            "required": true,
                            "form": "EventClassForm",
                            "url": "/eventClazz",
                            "width": 2
                        },
                        {
                            "id": "status",
                            "type": "RadioGroupField",
                            "name": "Status",
                            "alignment": "vertical",
                            "width": 2,
                            "radios": [{
                                type: "radio",
                                name: "Ok",
                                key: "Ok"
                            }, {
                                type: "radio",
                                name: "DidNotFinish",
                                key: "DidNotFinish"
                            }, {
                                type: "radio",
                                name: "DidNotStart",
                                key: "DidNotStart"
                            }, {
                                type: "radio",
                                name: "NoStartTime",
                                key: "NoStartTime"
                            }, {
                                type: "radio",
                                name: "MissingPunch",
                                key: "MissingPunch"
                            }, {
                                type: "radio",
                                name: "Disqualified",
                                key: "Disqualified"
                            }]
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "EntryForm",
                    "title": "Entry",
                    "url": "/entry",
                    "formFieldList": [
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "ControlForm",
                    "title": "Control",
                    "url": "/control",
                    "formFieldList": [
                        {
                            "id": "id",
                            "type": "text",
                            "name": "Number",
                            "required": true,
                            "width": 2
                        },
                        {
                            "id":   "event",
                            "type": "autocomplete",
                            "name": "Event",
                            "wordSearchEnabled": true,
                            "defaultKey": "eventKey",
                            "required": true,
                            "readonly": true,
                            "form": "EventForm",
                            "url": "/event",
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "CourseForm",
                    "title": "Course",
                    "url": "/course",
                    "formFieldList": [
                        {
                            "id": "name",
                            "type": "text",
                            "name": "Name",
                            "required": true,
                            "width": 2
                        },
                        {
                            "id":   "event",
                            "type": "autocomplete",
                            "name": "Event",
                            "wordSearchEnabled": true,
                            "defaultKey": "eventKey",
                            "required": true,
                            "readonly": true,
                            "form": "EventForm",
                            "url": "/event",
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "CourseControlForm",
                    "title": "Control",
                    "url": "/courseControl",
                    "formFieldList": [
                        {
                            "id":   "control",
                            "type": "autocomplete",
                            "name": "Control",
                            "wordSearchEnabled": true,
                            "defaultKey": "controlKey",
                            "required": true,
                            "readonly": true,
                            "form": "ControlForm",
                            "url": "/control",
                            "width": 2
                        },
                        {
                            "id":   "course",
                            "type": "autocomplete",
                            "name": "Course",
                            "wordSearchEnabled": true,
                            "defaultKey": "courseKey",
                            "required": true,
                            "readonly": true,
                            "form": "CourseForm",
                            "url": "/course",
                            "width": 2
                        },
                        {
                            "id": "sortOrder",
                            "type": "number",
                            "min": 1,
                            "max": 999999,
                            "name": "SortOrder",
                            "required": true,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "ClassForm",
                    "title": "Class",
                    "url": "/clazz",
                    "formFieldList": [
                        {
                            "id": "name",
                            "type": "text",
                            "name": "Name",
                            "required": true,
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
                {
                    "id": "EventClassForm",
                    "title": "Class",
                    "url": "/eventClazz",
                    "formFieldList": [
                        {
                            "id":   "clazz",
                            "type": "autocomplete",
                            "name": "Class",
                            "wordSearchEnabled": true,
                            "defaultKey": "classKey",
                            "required": true,
                            "readonly": true,
                            "form": "ClassForm",
                            "url": "/clazz",
                            "width": 2
                        },
                        {
                            "id":   "course",
                            "type": "autocomplete",
                            "name": "Course",
                            "wordSearchEnabled": true,
                            "required": true,
                            "readonly": true,
                            "form": "CourseForm",
                            "url": "/course",
                            "width": 2
                        },
                        {
                            "id":   "event",
                            "type": "autocomplete",
                            "name": "Event",
                            "wordSearchEnabled": true,
                            "defaultKey": "eventKey",
                            "required": true,
                            "readonly": true,
                            "form": "EventForm",
                            "url": "/event",
                            "width": 2
                        },
                        {
                            "type": "deleteButton",
                            "name": "Delete"
                        },
                        {
                            "type": "cancelButton",
                            "name": "Cancel"
                        },
                        {
                            "type": "okButton",
                            "name": "Ok"
                        }
                    ]
                },
            ],
            "pageList": [
                {
                    "id": "mainmenu",
                    "name": "MainMenu",
                    "elementList": [
                        {
                            "type": "button",
                            "name": "Entry",
                            "icon": "fa-address-card",
                            "color": "carrot",
                            "page": "entriespage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Results",
                            "icon": "fa-list-ol",
                            "color": "pomegranate",
                            "page": "resultspage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Admin",
                            "icon": "fa-cog",
                            "color": "concrete",
                            "page": "adminpage",
                        },
                    ]
                },
                {
                    "id": "entriespage",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h3>Please type your name (TODO: new entry or find existing entry)</h3>"
                        },
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "list",
                            "icon": "fa-user",
                            "color": "pink",
                            "search": true,
                            "limit": 100,
                            "url": "/runner",
                            "page": "entryclasspage"
                        },
                        {
                            "type": "pageLabel",
                            "value": "<h3>If you cannot find yourself, please create a new runner</h3>",
                            "newRow": true,
                        },
                        {
                            "type": "newButton",
                            "name": "NewRunner",
                            "width": 2,
                            "icon": "fa-user",
                            "color": "green",
                            "form": {
                                "form": "RunnerForm"
                            }
                        },
                    ]
                },
                {
                    "id": "entryclasspage",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h3>Please select a class</h3>"
                        },
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "list",
                            "icon": "fa-users",
                            "color": "wet-asphalt",
                            "search": false,
                            "url": "/event/:eventKey/eventClazz",
                            "page": "entryconfirmedpage"
                        }
                    ]
                },
                {
                    "id": "entryconfirmedpage",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h3>Your entry is confirmed.</h3>"
                        },
                        {
                            "type": "list",
                            "icon": "fa-thumbs-up",
                            "color": "green",
                            "search": false,
                            "url": "/entry/:entryKey/runner/:runnerKey/eventClazz/:eventClazzKey",
                            "form": {
                                "form": "RaceForm"
                            }
                        }
                    ]
                },
                {
                    "id": "resultspage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "Latest",
                            "icon": "fa-list-ol",
                            "color": "carrot",
                            "page": "resultslatestpage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Class",
                            "icon": "fa-list-ol",
                            "color": "wet-asphalt",
                            "page": "resultsclasspage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Course",
                            "icon": "fa-list-ol",
                            "color": "wisteria",
                            "page": "resultscoursepage",
                            "tooltip": "NotYetImplemented",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "All",
                            "icon": "fa-list-ol",
                            "color": "lime",
                            "page": "resultsallpage",
                            "width": 2,
                        },
                    ]
                },
                {
                    "id": "adminpage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "Events",
                            "icon": "fa-calendar",
                            "color": "belize hole",
                            "page": "eventspage",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Runners",
                            "icon": "fa-user",
                            "color": "pink",
                            "page": "runnerspage",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Ecards",
                            "icon": "fa-tag",
                            "color": "teal",
                            "page": "ecardspage",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Classes",
                            "icon": "fa-users",
                            "color": "wet-asphalt",
                            "page": "classespage",
                            "width": 2,
                        },
                    ]
                },
                {
                    "id": "eventspage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewEvent",
                            "width": 2,
                            "icon": "fa-calendar",
                            "color": "green",
                            "form": {
                                "form": "EventForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-calendar",
                            "color": "belize hole",
                            "search": false,
                            "url": "/event",
                            "page": "eventpage"
                        }
                    ]
                },
                {
                    "id": "eventpage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "EditEvent",
                            "width": 2,
                            "icon": "fa-calendar",
                            "color": "green",
                            "form": {
                                "form": "EventForm"
                            }
                        },
                        {
                            "type": "list",
                            "name": "Courses",
                            "icon": "fa-map",
                            "color": "wisteria",
                            "search": false,
                            "url": "/event/:eventKey/course/summary",
                            "page": "coursespage",
                            "width": 2,
                        },
                        {
                            "type": "list",
                            "name": "Classes",
                            "icon": "fa-users",
                            "color": "wet-asphalt",
                            "search": false,
                            "url": "/event/:eventKey/eventClazz/summary",
                            "page": "eventclassespage",
                            "width": 2,
                        },
                        {
                            "type": "list",
                            "name": "Controls",
                            "icon": "fa-map-pin",
                            "color": "alizarin",
                            "search": false,
                            "url": "/event/:eventKey/control/summary",
                            "page": "controlspage",
                            "width": 2,
                        },
                    ]
                },
                {
                    "id": "controlspage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewControl",
                            "width": 2,
                            "icon": "fa-map-pin",
                            "color": "green",
                            "form": {
                                "form": "ControlForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-map-pin",
                            "color": "alizarin",
                            "search": false,
                            "url": "/event/:eventKey/control",
                            "form": {
                                "form": "ControlForm"
                            }
                        }
                    ]
                },
                {
                    "id": "coursespage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewCourse",
                            "width": 2,
                            "icon": "fa-map",
                            "color": "green",
                            "form": {
                                "form": "CourseForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-map",
                            "color": "wisteria",
                            "search": false,
                            "url": "/event/:eventKey/course",
                            "page": "coursepage"
                        }
                    ]
                },
                {
                    "id": "coursepage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "EditCourse",
                            "width": 2,
                            "icon": "fa-map",
                            "color": "green",
                            "form": {
                                "form": "CourseForm"
                            }
                        },
                        {
                            "type": "newButton",
                            "name": "AddControl",
                            "width": 2,
                            "icon": "fa-map-pin",
                            "color": "green",
                            "form": {
                                "form": "CourseControlForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-map-pin",
                            "color": "alizarin",
                            "search": false,
                            "url": "/course/:courseKey/courseControl",
                            "form": {
                                "form": "CourseControlForm"
                            }
                        }
                    ]
                },
                {
                    "id": "eventclassespage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "AddClass",
                            "width": 2,
                            "icon": "fa-users",
                            "color": "green",
                            "form": {
                                "form": "EventClassForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-users",
                            "color": "wet-asphalt",
                            "search": false,
                            "url": "/event/:eventKey/eventClazz",
                            "form": {
                                "form": "EventClassForm"
                            }
                        }
                    ]
                },
                {
                    "id": "runnerspage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewRunner",
                            "width": 2,
                            "icon": "fa-user",
                            "color": "green",
                            "form": {
                                "form": "RunnerForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-user",
                            "color": "pink",
                            "search": true,
                            "limit": 100,
                            "url": "/runner",
                            "form": {
                                "form": "RunnerForm"
                            }
                        }
                    ]
                },
                {
                    "id": "ecardspage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewEcard",
                            "width": 2,
                            "icon": "fa-tag",
                            "color": "green",
                            "form": {
                                "form": "EcardForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-tag",
                            "color": "teal",
                            "search": true,
                            "limit": 100,
                            "url": "/ecard",
                            "form": {
                                "form": "EcardForm"
                            }
                        }
                    ]
                },
                {
                    "id": "classespage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "newButton",
                            "name": "NewClass",
                            "width": 2,
                            "icon": "fa-users",
                            "color": "green",
                            "form": {
                                "form": "ClassForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-users",
                            "color": "wet-asphalt",
                            "search": true,
                            "url": "/clazz",
                            "form": {
                                "form": "ClassForm"
                            }
                        }
                    ]
                },
                {
                    "id": "resultsallpage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "list",
                            "icon": "fa-space-shuttle",
                            "color": "lime",
                            "search": true,
                            "url": "/race",
                            "page": "racepage"
                        }
                    ]
                },
                {
                    "id": "racepage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "EditRace",
                            "width": 2,
                            "icon": "fa-space-shuttle",
                            "color": "green",
                            "form": {
                                "form": "RaceForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-pin",
                            "color": "lime",
                            "search": true,
                            "url": "/raceControl",
                        }
                    ]
                },
            ]
        }
    };


    get guiModel() {
        return this._guiModel;
    }
}