## [2.1.1](https://github.com/wetransform/uba-end-automation/compare/v2.1.0...v2.1.1) (2024-10-15)


### Bug Fixes

* **df7_10:** add separate task for Agglomerations Quiet Areas ([2a40096](https://github.com/wetransform/uba-end-automation/commit/2a400966ef284553070bb6e1cb2a6ec759dde96f)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)

## [2.1.0](https://github.com/wetransform/uba-end-automation/compare/v2.0.1...v2.1.0) (2024-09-13)


### Features

* add helper tasks for validation, aggregation and cleaning ([378040d](https://github.com/wetransform/uba-end-automation/commit/378040da2eb12cc275bfd7b9ce596e1df844d82b)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add support for additional source folders in config ([976395f](https://github.com/wetransform/uba-end-automation/commit/976395f1d918ecbc3866c909a6eb7ffc5e9af1c4)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add support for Agglomerations validation and aggregation ([da6a416](https://github.com/wetransform/uba-end-automation/commit/da6a416e5842cdcc649705d3508128858a1f194f)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add support for Major Airports validation and aggregation ([48bc200](https://github.com/wetransform/uba-end-automation/commit/48bc2001d2e78fc8b3a15b0fdd133883e3218716)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add support for Major Railways validation and aggregation ([703b651](https://github.com/wetransform/uba-end-automation/commit/703b6517f01c4427c410ebcf4df21fc37df2aaf4)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add support for Quiet Areas validation and aggregation ([a74ca53](https://github.com/wetransform/uba-end-automation/commit/a74ca53d65c4ed17b79eb60eff142a3614d4a0b6)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add support for sheets configuration ([93a4da7](https://github.com/wetransform/uba-end-automation/commit/93a4da7950f5ab5e20288e4cf07a4f8a0ab7d52f)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add tasks for aggregating Coverage Areas ([4e57168](https://github.com/wetransform/uba-end-automation/commit/4e5716858d423062e19211f3bc3dcf24483a7c89)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add validation tasks for deriving Coverage Areas ([5b287eb](https://github.com/wetransform/uba-end-automation/commit/5b287eb41bedb685e7b710cc422283d59246aaa7)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* **df7_10:** add aggregation runs to summary log ([0808480](https://github.com/wetransform/uba-end-automation/commit/0808480839059e312be6f6f5d5438f1e7a805333)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* **df7_10:** add validation type to summary log ([4157963](https://github.com/wetransform/uba-end-automation/commit/4157963484ee4a686d55b3ec1973d5610953ea62)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* **df7_10:** show separate validation type for Quiet Areas in summary ([e6f653d](https://github.com/wetransform/uba-end-automation/commit/e6f653da8e50d19830195408ea7a448fc239daf9)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)


### Bug Fixes

* avoid failure of success validation in case of multiple source files ([8da6e73](https://github.com/wetransform/uba-end-automation/commit/8da6e7385d293338096539ea6c2af513e2eaaba7)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)

## [2.0.1](https://github.com/wetransform/uba-end-automation/compare/v2.0.0...v2.0.1) (2024-08-27)


### Bug Fixes

* use hale»studio 5.3.0 libraries ([9246963](https://github.com/wetransform/uba-end-automation/commit/92469631306987bb7731bcb958e0773f5e4a70c6)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)

## [2.0.0](https://github.com/wetransform/uba-end-automation/compare/v1.1.1...v2.0.0) (2024-06-07)


### ⚠ BREAKING CHANGES

* upgrade gradle-hale-plugin and hale version

### Features

* add automation for DF7_10 Major Roads ([9eaebbd](https://github.com/wetransform/uba-end-automation/commit/9eaebbd15b2a59584b4e27bda9d031c4ee09a021)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
* add distribution plugin ([e2f5f19](https://github.com/wetransform/uba-end-automation/commit/e2f5f19ee911242355c167ebb68d6a5074532420)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)


### Bug Fixes

* make Gradle script robust against missing input directory ([896fa9e](https://github.com/wetransform/uba-end-automation/commit/896fa9e3041a6e0b155d587b9e3e4885fe9503b8)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)


### Code Refactoring

* upgrade gradle-hale-plugin and hale version ([e898004](https://github.com/wetransform/uba-end-automation/commit/e898004aa295ce79ce1e31fe862510907b4c887b)), closes [SVC-1812](https://wetransform.atlassian.net/browse/SVC-1812)
