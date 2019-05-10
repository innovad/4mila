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
                            "id":   "defaultEcard",
                            "type": "autocomplete",
                            "name": "Ecard",
                            "wordSearchEnabled": true,
                            "defaultKey": "ecardKey",
                            "required": true,
                            "form": "EcardForm",
                            "url": "/ecard"
                        },
                        {
                            "id": "city",
                            "type": "text",
                            "name": "City",
                            "required": false
                        },
                        {
                            "id": "email",
                            "type": "text",
                            "name": "Email",
                            "required": false
                        },
                        {
                            "id": "id",
                            "type": "text",
                            "name": "ID",
                            "required": false
                        },
                        {
                            "id": "yearOfBirth",
                            "type": "number",
                            "name": "YearOfBirth",
                            "required": false
                        },
                        {
                            "id": "sex",
                            "type": "RadioGroupField",
                            "name": "Sex",
                            "alignment": "horizontal",
                            "width": 1,
                            "radios": [{
                                type: "radio",
                                name: "Male",
                                key: "m"
                            }, {
                                type: "radio",
                                name: "Female",
                                key: "f"
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
                    "id": "RunnerImportForm",
                    "title": "Runner",
                    "formFieldList": [
                        {
                            "id": "fileUpload",
                            "type": "fileUpload",
                            "name": "File",
                            "url": "/upload",
                            "multiple": false,
                            "acceptedFileTypes": [".csv", ".txt"],
                            "width": 2,
                            "required": true
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
                            "alignment": "horizontal",
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
                    "id": "RaceControlForm",
                    "title": "RaceControl",
                    "url": "/raceControl",
                    "formFieldList": [
                        {
                            "id":   "race",
                            "type": "autocomplete",
                            "name": "Race",
                            "wordSearchEnabled": true,
                            "defaultKey": "raceKey",
                            "required": true,
                            "form": "RaceForm",
                            "url": "/race",
                            "width": 2
                        },
                        {
                            "id":   "courseControl",
                            "type": "autocomplete",
                            "name": "Control",
                            "wordSearchEnabled": true,
                            "defaultKey": "courseControlKey",
                            "required": true,
                            "form": "CourseControlForm",
                            "url": "/courseControl",
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
                            "id": "status",
                            "type": "RadioGroupField",
                            "name": "Status",
                            "alignment": "horizontal",
                            "width": 2,
                            "radios": [{
                                type: "radio",
                                name: "InitialStatus",
                                key: "InitialStatus"
                            }, {
                                type: "radio",
                                name: "Ok",
                                key: "Ok"
                            }, {
                                type: "radio",
                                name: "Missing",
                                key: "Missing"
                            }, {
                                type: "radio",
                                name: "Additional",
                                key: "Additional"
                            }, {
                                type: "radio",
                                name: "Wrong",
                                key: "Wrong"
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
                    "urlDefaults": true,
                    "formFieldList": [
                        {
                            "id": "id",
                            "type": "text",
                            "name": "Number",
                            "required": true,
                            "width": 2
                        },
                        {
                            "id": "type",
                            "type": "RadioGroupField",
                            "name": "Type",
                            "alignment": "horizontal",
                            "width": 2,
                            "radios": [{
                                type: "radio",
                                name: "Control",
                                key: "control"
                            }, {
                                type: "radio",
                                name: "Start",
                                key: "start"
                            }, {
                                type: "radio",
                                name: "Finish",
                                key: "finish"
                            }
                            ]
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
                            "id": "length",
                            "type": "text",
                            "name": "Length",
                            "required": false,
                            "width": 1
                        },
                        {
                            "id": "climb",
                            "type": "text",
                            "name": "Climb",
                            "required": false,
                            "width": 1
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
                    "id": "CourseImportForm",
                    "title": "Course",
                    "formFieldList": [
                        {
                            "id": "fileUpload",
                            "type": "fileUpload",
                            "name": "File",
                            "url": "/upload/event/:eventKey/course",
                            "multiple": false,
                            "acceptedFileTypes": [".xml"],
                            "width": 2,
                            "required": true
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
                            "type": "pageLabel",
                            "value": "<h3>Welcome! Please insert your E-Card to register or download!</h3>",
                            "newRow": true
                        },
                        {
                            "type": "button",
                            "name": "InsertEcard",
                            "icon": "fa-tag",
                            "color": "green",
                            "width": 4,
                        },
                        {
                            "type": "pageLabel",
                            "value": "<h3>Browse entries or results:</h3>",
                            "newRow": true
                        },
                        {
                            "type": "button",
                            "name": "BrowseEntries",
                            "icon": "fa-address-card",
                            "color": "carrot",
                            "page": "EntriesPage",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "BrowseResults",
                            "icon": "fa-list-ol",
                            "color": "blue",
                            "page": "resultspage",
                            "width": 2,
                        },
                        {
                            "type": "pageLabel",
                            "value": "<h3>Admin and Test features</h3>",
                            "newRow": true
                        },
                        {
                            "type": "button",
                            "name": "Admin",
                            "icon": "fa-cog",
                            "color": "concrete",
                            "page": "adminpage",
                            "permissionUrl": "/permission/isAdmin",
                        },
                        {
                            "type": "button",
                            "name": "TestECard",
                            "icon": "fa-tag",
                            "color": "silver",
                            "page": "TestECardPage",
                            "width": 2,
                        },
                    ]
                },
                {
                    "id": "TestECardPage",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h3>ECard without runner:</h3>"
                        },
                        {
                            "type": "list",
                            "icon": "fa-tag",
                            "color": "green",
                            "search": true,
                            "url": "/ecard/withoutRunner",
                            "page": "AddEntryPage",
                            "newRow": true,
                        },
                        {
                            "type": "pageLabel",
                            "value": "<h3>ECard with runner:</h3>",
                            "newRow": true,
                        },
                        {
                            "type": "list",
                            "icon": "fa-tag",
                            "color": "green",
                            "search": true,
                            "url": "/runner/withECard",
                            "page": "AddEntryClassPage",
                        }
                    ]
                },
                {
                    "id": "DownloadResultsPage",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h3>Thank you Mr. XY! Your results have been downloaded:</h3>"
                        },
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "button",
                            "name": "Status: OK",
                            "icon": "fa-tag",
                            "color": "green",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Time: XX:YY",
                            "icon": "fa-clock",
                            "color": "green",
                            "width": 2,
                        },
                        {
                            "type": "button",
                            "name": "Current Rank: 1/20",
                            "icon": "fa-list-ol",
                            "color": "green",
                            "width": 2,
                        },
                    ]
                },
                {
                    "id": "AddEntryPage",
                    "elementList": [
                        {
                            "type": "pageLabel",
                            "value": "<h3>Unknown E-Card. Please search the runner database:</h3>"
                        },
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "list",
                            "icon": "fa-user",
                            "color": "pink",
                            "search": true,
                            "searchRequired": true,
                            "searchRequest": true,
                            "limit": 10,
                            "url": "/search/runner",
                            "page": "AddEntryClassPage"
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
                    "id": "AddEntryClassPage",
                    "elementList": [
                        {
                            "type": "elementList",
                            "url": "/message/runner/:runnerKey",
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
                            "page": "EntryConfirmedPage"
                        }
                    ]
                },
                {
                    "id": "EntryConfirmedPage",
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
                            "url": "/entry/:entryKey/ecard/:ecardKey/runner/:runnerKey/eventClazz/:eventClazzKey",
                            "form": {
                                "form": "RaceForm"
                            }
                        }
                    ]
                },
                {
                    "id": "EntriesPage",
                    "elementList": [
                        {
                            "type": "backbutton",
                        },
                        {
                            "type": "list",
                            "icon": "fa-thumbs-up",
                            "color": "green",
                            "search": false,
                            "url": "/race",
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
                        }
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
                            "icon": "fa-circle",
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
                            "icon": "fa-circle",
                            "color": "green",
                            "form": {
                                "form": "ControlForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-circle",
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
                            "type": "newButton",
                            "name": "Import",
                            "width": 2,
                            "icon": "fa-file-import",
                            "color": "green",
                            "form": {
                                "form": "CourseImportForm"
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
                            "icon": "fa-circle",
                            "color": "green",
                            "form": {
                                "form": "CourseControlForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-circle",
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
                            "type": "newButton",
                            "name": "Import",
                            "width": 2,
                            "icon": "fa-file-import",
                            "color": "green",
                            "form": {
                                "form": "RunnerImportForm"
                            }
                        },
                        {
                            "type": "list",
                            "icon": "fa-user",
                            "color": "pink",
                            "search": true,
                            "searchRequired": true,
                            "searchRequest": true,
                            "limit": 10,
                            "url": "/search/runner",
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
                            "url": "/race/:raceKey/raceControl",
                            "form": {
                                "form": "RaceControlForm"
                            }
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
