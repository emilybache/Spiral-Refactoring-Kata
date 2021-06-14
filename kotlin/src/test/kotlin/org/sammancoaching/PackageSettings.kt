package org.sammancoaching

import org.approvaltests.core.ApprovalFailureReporter
import org.approvaltests.reporters.JunitReporter

/**
 * Configure the reporter used by Approval Tests.
 * Documentation: https://github.com/approvals/ApprovalTests.Java/blob/master/approvaltests/docs/Reporters.md
 */
class PackageSettings {
    var UseReporter: ApprovalFailureReporter = JunitReporter.INSTANCE
}