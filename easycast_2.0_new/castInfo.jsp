<%@ page
        contentType="text/html;charset=utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Expires" content="Mon, 20 Jan 2001 20:01:21 GMT" />
<meta name="generator" content="Robot 2.5.1 (Python 2.5.1 on linux2)" />



<style media="all" type="text/css">
  body {
    background: #009ad6;
  }
  /* Generic Table Styles */
  table {
    background: white;
    border: 1px solid black;
    border-collapse: collapse;
    empty-cells: show;
    margin: 0px 1px;
  }
  th, td {
    border: 1px solid black;
    padding: 1px 5px;
  }
  th {
    background: #a1a3a6;
    color: black;
  }
  /* Test by Suite/Tag Tables */
  table.tests_by_suite, table.tests_by_tag {
    width: 100%;
  }
  .col_name {
    width: 13em;
    font-weight: bold;
  }
  .col_doc {
    min-width: 13em;
  }
  .col_tags {
    width: 10em;
  }
  .col_crit {
    width: 2em;
    text-align: center;
  }
  .col_status {
    width: 3.5em;
    text-align: center;
  }
  .col_msg {
    min-width: 13em;
  }
  .col_times {
    width: 9em;
  }
  td.col_times{
    text-align: right;
  }
  .suite_row_fail, .tag_row{
    background: #d93a49;
  }
  .suite_row_pass, .tag_row{
    background: #1d953f;
  }
  .meta_name {
    font-weight: bold;
  }
  /* Details Table */
  table.details {
    width: 30em;
  }
  table.details th {
    background: white;
    width: 9em;
    text-align: left;
    vertical-align: top;
    padding-right: 1em;
    border: none;
    padding: 2px 4px;
  }
  table.details td {
    vertical-align: top;
    border: none;
    padding: 2px 4px;
  }
  .status_fail {
    color: red;
    font-weight: bold;
  }
  .status_pass {
    color: #009900;
  }
</style>
<style media="all" type="text/css">
  /* Generic styles */
  body {
    font-family: sans-serif;
    font-size: 0.8em;
    color: black;
    padding: 6px;
  }
  h2 {
    margin-top: 1.2em;
  }
  /* Statistics Table */
  table.statistics {
    width: 60em;
    border: 1px solid black;
    border-collapse: collapse;
    empty-cells: show;
    margin-bottom: 1em;
  }
  
    table.statistics_1 {
    width: 20em;
    border: 1px solid black;
    border-collapse: collapse;
    empty-cells: show;
    margin-bottom: 1em;
  }

  
  table.statistics td, table.statistics th {
    border: 1px solid black;
    padding: 1px 4px;
    margin: 0px;
  }
  table.statistics th {
    background: #C6C6C6;
  }
  .col_stat_name {
    width: 80em;
    text-align: center;
  }
  .col_stat {
    width: 3em;
    text-align: center;
  }
  .col_stat_discription {
    white-space: nowrap;
    text-align: center;
  }
  .stat_name {
    text-align: center
  }
  .stat_name a, .stat_name span {
    font-weight: bold;
  }
  .tag_links {
    font-size: 0.9em;
    float: right;
    margin-top: 0.05em;
  }
  .tag_links span {
    margin-left: 0.2em;
  }
  /* Statistics Table Graph */
  .pass_bar {
    background: #00f000;
  }
  .fail_bar {
    background: red;
  }
  .no_tags_bar {
    background: #E9E9E9;
  }
  .graph {
    position: relative;
    border: 1px solid black;
    width: 11em;
    height: 0.75em;
    padding: 0px;
    background: #E9E9E9;
  }
  .graph b {
    display: block;
    position: relative;
    height: 100%;
    float: left;
    font-size: 4px;  /* to make graphs thin also in IE */
  }
  /* Tables in documentation */
  table.doc {
    border: 1px solid gray;
    background: transparent;
    border-collapse: collapse;
    empty-cells: show;
    font-size: 0.9em;
  }
  table.doc td {
    border: 1px solid gray;
    padding: 0.1em 0.3em;
    height: 1.2em;
  }
  /* Misc Styles */
  .not_available {
    color: gray;      /* no grey in IE */
    font-weight: normal;
  }
  .parent_name {
    font-size: 0.7em;
    letter-spacing: -0.07em;
  }
  a:link, a:visited {
    text-decoration: none;
    color: blue;
  }
  a:hover, a:active {
    text-decoration: underline;
    color: purple;
  }
  /* Headers */
  .header {
    width: 58em;
    margin: 6px 3px;
  }
  h1 {
    margin: 0px;
    width: 50%;
    float: left;
  }
  .times {
    width: 60%;
    float: right;
    text-align: center;
	font-weight:bold
  }
  .generated_time, .generated_ago {
    font-size: 0.9em;
  }
  .spacer {
    font-size: 0.8em;
    clear: both;
  }
  /* Status text colors */
  .error, .fail {
    color: red;
  }
  .pass {
    color: #009900;
  }
  .warn {
    color: #FFCC00;
  }
  .not_run {
    color: #663300;
  }
</style>
<style media="print" type="text/css">
  body {
    background: white;
    padding: 0px;
    font-size: 8pt;
  }
  a:link, a:visited {
    color: black;
  }
  .header, table.details, table.statistics {
    width: 100%;
  }
  .generated_ago, .expand {
    display: none;
  }
</style>
</head>

<body>
<div class="header">
  <h1>ark_rms_move_info summary</h1>
  <div class="times">
  <div id="time" align="center">Current Time:</div> 

<table class="statistics ">
<th class="col_stat_name">workflow_Info.</th>
<th class="col_stat">shelfcode</th>
<th class="col_stat_time">time</th>
<th class="col_stat_ip">remote_ip</th>
<th class="col_stat_date">date</th>
<th class="col_stat_discription">otherDescription</th>
</tr>

