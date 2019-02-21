(ns re-com.mui
  (:require [reagent.core :as r]
            [goog.object :as gobj]
            [material-ui]))

(defn mui->reagent [name]
  (r/adapt-react-class (gobj/get js/MaterialUI name)))

(def app-bar (mui->reagent "AppBar"))
(def avatar (mui->reagent "Avatar"))
(def backdrop (mui->reagent "Backdrop"))
(def bottom-navigation (mui->reagent "BottomNavigation"))
(def bottom-navigation-action (mui->reagent "BottomNavigationAction"))
(def button (mui->reagent "Button"))
(def button-base (mui->reagent "ButtonBase"))
(def card (mui->reagent "Card"))
(def card-action-area (mui->reagent "CardActionArea"))
(def card-actions (mui->reagent "CardActions"))
(def card-content (mui->reagent "CardContent"))
(def card-header (mui->reagent "CardHeader"))
(def card-media (mui->reagent "CardMedia"))
(def checkbox (mui->reagent "Checkbox"))
(def chip (mui->reagent "Chip"))
(def circular-progress (mui->reagent "CircularProgress"))
(def click-away-listener (mui->reagent "ClickAwayListener"))
(def collapse (mui->reagent "Collapse"))
(def css-baseline (mui->reagent "CssBaseline"))
(def dialog (mui->reagent "Dialog"))
(def dialog-actions (mui->reagent "DialogActions"))
(def dialog-content (mui->reagent "DialogContent"))
(def dialog-content-text (mui->reagent "DialogContentText"))
(def dialog-title (mui->reagent "DialogTitle"))
(def divider (mui->reagent "Divider"))
(def drawer (mui->reagent "Drawer"))
(def expansion-panel (mui->reagent "ExpansionPanel"))
(def expansion-panel-actions (mui->reagent "ExpansionPanelActions"))
(def expansion-panel-details (mui->reagent "ExpansionPanelDetails"))
(def expansion-panel-summary (mui->reagent "ExpansionPanelSummary"))
(def fab (mui->reagent "Fab"))
(def fade (mui->reagent "Fade"))
(def filled-input (mui->reagent "FilledInput"))
(def form-control (mui->reagent "FormControl"))
(def form-control-label (mui->reagent "FormControlLabel"))
(def form-group (mui->reagent "FormGroup"))
(def form-helper-text (mui->reagent "FormHelperText"))
(def form-label (mui->reagent "FormLabel"))
(def grid (mui->reagent "Grid"))
(def grid-list (mui->reagent "GridList"))
(def grid-list-tile (mui->reagent "GridListTile"))
(def grid-list-tile-bar (mui->reagent "GridListTileBar"))
(def grow (mui->reagent "Grow"))
(def hidden (mui->reagent "Hidden"))
(def icon (mui->reagent "Icon"))
(def icon-button (mui->reagent "IconButton"))
(def input (mui->reagent "Input"))
(def input-adornment (mui->reagent "InputAdornment"))
(def input-base (mui->reagent "InputBase"))
(def input-label (mui->reagent "InputLabel"))
(def linear-progress (mui->reagent "LinearProgress"))
(def link (mui->reagent "Link"))
(def list (mui->reagent "List"))
(def list-item (mui->reagent "ListItem"))
(def list-item-avatar (mui->reagent "ListItemAvatar"))
(def list-item-icon (mui->reagent "ListItemIcon"))
(def list-item-secondary-action (mui->reagent "ListItemSecondaryAction"))
(def list-item-text (mui->reagent "ListItemText"))
(def list-subheader (mui->reagent "ListSubheader"))
(def menu (mui->reagent "Menu"))
(def menu-item (mui->reagent "MenuItem"))
(def menu-list (mui->reagent "MenuList"))
(def mobile-stepper (mui->reagent "MobileStepper"))
(def modal (mui->reagent "Modal"))
(def modal-manager (mui->reagent "ModalManager"))
(def mui-theme-provider (mui->reagent "MuiThemeProvider"))
(def native-select (mui->reagent "NativeSelect"))
(def no-ssr (mui->reagent "NoSsr"))
(def outlined-input (mui->reagent "OutlinedInput"))
(def paper (mui->reagent "Paper"))
(def popover (mui->reagent "Popover"))
(def popper (mui->reagent "Popper"))
(def portal (mui->reagent "Portal"))
(def radio (mui->reagent "Radio"))
(def radio-group (mui->reagent "RadioGroup"))
(def root-ref (mui->reagent "RootRef"))
(def select (mui->reagent "Select"))
(def slide (mui->reagent "Slide"))
(def snackbar (mui->reagent "Snackbar"))
(def snackbar-content (mui->reagent "SnackbarContent"))
(def step (mui->reagent "Step"))
(def step-button (mui->reagent "StepButton"))
(def step-connector (mui->reagent "StepConnector"))
(def step-content (mui->reagent "StepContent"))
(def step-icon (mui->reagent "StepIcon"))
(def step-label (mui->reagent "StepLabel"))
(def stepper (mui->reagent "Stepper"))
(def svg-icon (mui->reagent "SvgIcon"))
(def swipeable-drawer (mui->reagent "SwipeableDrawer"))
(def switch (mui->reagent "Switch"))
(def tab (mui->reagent "Tab"))
(def table (mui->reagent "Table"))
(def table-body (mui->reagent "TableBody"))
(def table-cell (mui->reagent "TableCell"))
(def table-footer (mui->reagent "TableFooter"))
(def table-head (mui->reagent "TableHead"))
(def table-pagination (mui->reagent "TablePagination"))
(def table-row (mui->reagent "TableRow"))
(def table-sort-label (mui->reagent "TableSortLabel"))
(def tabs (mui->reagent "Tabs"))
(def text-field (mui->reagent "TextField"))
(def toolbar (mui->reagent "Toolbar"))
(def tooltip (mui->reagent "Tooltip"))
#_(def touch-ripple (mui->reagent "TouchRipple"))
(def typography (mui->reagent "Typography"))
(def zoom (mui->reagent "Zoom"))


(def create-generate-class-name* (.createGenerateClassName js/MaterialUI))
(def create-mui-theme* (.createMuiTheme js/MaterialUI))
(def create-styles* (.createStyles js/MaterialUI))
(def jss-preset* (.jssPreset js/MaterialUI))
(def with-mobile-dialog* (.withMobileDialog js/MaterialUI))
(def with-styles* (.withStyles js/MaterialUI))
(def with-theme* (.withTheme js/MaterialUI))
(def with-width* (.withWidth js/MaterialUI))