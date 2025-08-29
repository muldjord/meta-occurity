SUMMARY = "Recipe for Occurity visual acuity software"
DESCRIPTION = "Recipe for building and installing the Occurity visual acuity software"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-3.0-only;md5=c79ff39f19dfec6d293b95dea7b07891"

SRC_URI = "git://github.com/muldjord/occurity.git;branch=qt6;protocol=https"
PV = "1.3.1+git${SRCPV}"
SRCREV = "dc2a7e3745f88186871e7b5b8a7c996ec844aa31"

DEPENDS:append = " qtbase qtmultimedia qtsvg qttools-native"

RDEPENDS:${PN} += " bash"

inherit qt6-cmake

EXTRA_OECMAKE = "\
    -DCMAKE_PREFIX_PATH=${STAGING_DIR_TARGET}${prefix} \
    -DCMAKE_BUILD_TYPE=Release \
"

S = "${WORKDIR}/git"

do_install:append() {
    # Install the application
    install -d ${D}/home/root/occurity/
    install -m 0755 ${S}/release/Occurity ${D}/home/root/occurity/
    install -m 0664 ${S}/AUTHORS ${D}/home/root/occurity/
    install -m 0664 ${S}/charts.xml.example ${D}/home/root/occurity/
    install -m 0664 ${S}/LICENSE ${D}/home/root/occurity/
    install -m 0664 ${S}/occurity_da_DK.qm ${D}/home/root/occurity/
    install -m 0664 ${S}/README.md ${D}/home/root/occurity/
    cp -R ${S}/optotypes ${D}/home/root/occurity/
    cp -R ${S}/docs ${D}/home/root/occurity/
    cp -R ${S}/flirc_configs ${D}/home/root/occurity/
    cp -R ${S}/scripts ${D}/home/root/occurity/
    cp -R ${S}/jobs ${D}/home/root/occurity/
    cp -R ${S}/svg ${D}/home/root/occurity/
    cp -R ${S}/videos ${D}/home/root/occurity/

    # Force 'ffmpeg' as default for Qt6 Multimedia video playback
    install -d ${D}${sysconfdir}/profile.d
    echo 'export QT_MEDIA_BACKEND=ffmpeg' > ${D}${sysconfdir}/profile.d/qt-media-backend.sh
}

FILES:${PN} += "/home/root/occurity/"
